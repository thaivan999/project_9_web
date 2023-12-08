package hcmute.controller.user;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import hcmute.embeddedId.CartDetailId;
import hcmute.entity.BranchEntity;
import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.model.MilkTeaModel;
import hcmute.model.OrderProduct;
import hcmute.model.OrderProduct.OrderItem;
import hcmute.service.IBranchService;
import hcmute.service.ICartDetailService;
import hcmute.service.IMilkTeaService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	ICartDetailService cartDetailService;

	@Autowired
	IMilkTeaService milkTeaService;

	@Autowired
	IBranchService branchService;

	private List<MilkTeaModel> getList() {
		List<CartDetailId> milkTeas = cartDetailService.findMilkTeaByCartId(3);
		List<MilkTeaModel> listmilkteas = new ArrayList<MilkTeaModel>();
		for (CartDetailId result : milkTeas) {
			Optional<MilkTeaEntity> milktea = milkTeaService.findByIdMilkTea(result.getIdMilkTea());
			if (milktea.isPresent()) {
				MilkTeaEntity entity = milktea.get();
				String size = result.getSize();
				MilkTeaModel milkTeaModel = new MilkTeaModel();
				BeanUtils.copyProperties(entity, milkTeaModel);
				milkTeaModel.setSize(size);
				listmilkteas.add(milkTeaModel);
			}
		}
		return listmilkteas;
	}

	@GetMapping("")
	public String list(ModelMap model, @RequestParam(value = "status", required = false) String status) {
		model.addAttribute("listmilkteas", this.getList());
		model.addAttribute("status", status);
		if (status != null) {
			if ("success".equals(status)) {
				model.addAttribute("message", "Xóa thành công");
			} else {
				model.addAttribute("message", "Xóa thất bại");
			}
		}
		return "user/cart";
	}

	@GetMapping("/check")
	public String check(ModelMap model, @RequestParam("data") String data, @RequestParam("noChoose") String noChoose) {
		if(noChoose.equals("true")) {
			model.addAttribute("message",
					"Quý khách chưa chọn sản phẩm để đặt hàng!");
			model.addAttribute("status", "fail");
			model.addAttribute("listmilkteas", this.getList());
			return "user/cart";
		}
		String dataEncoded = data;
		byte[] decodedBytes = Base64.getDecoder().decode(data);
		data = new String(decodedBytes, StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		List<BranchEntity> listBranches = branchService.findAll();
		try {
			OrderProduct orderProduct = objectMapper.readValue(data, OrderProduct.class);
			int idBranchOrder = -1;
			for (BranchEntity branch : listBranches) {
				Boolean isChecked = true;
				for (OrderItem item : orderProduct.getList()) {
					int idMilkTea = Integer.parseInt(item.getIdMilkTea());
					Optional<MilkTeaEntity> entity = milkTeaService.findByIdMilkTea(idMilkTea);
					if (entity.isPresent()) {
						int idBranch = branch.getIdBranch();
						Optional<Integer> remainQuantityOptional = milkTeaService
								.findRemainQuantityByIdMilkTeaAndIdBranch(idMilkTea, idBranch);
						if (remainQuantityOptional.isPresent()) {
							if (remainQuantityOptional.get() < Integer.parseInt(item.getQuantity())) {
								isChecked = false;
								break;
							}
						} else {
							isChecked = false;
							break;
						}
					}
				}
				if (isChecked) {
					idBranchOrder = branch.getIdBranch();
					break;
				}
			}
			if (idBranchOrder != -1) {
				return "redirect:/payment?data=" + dataEncoded + "&idBranch=" + idBranchOrder;
			} else {
				model.addAttribute("message",
						"Xin lỗi quý khách! Hiện tại toàn bộ các chi nhánh không có đủ số lượng đáp ứng cho toàn bộ sản phẩm bạn đã đặt hàng!");
				model.addAttribute("status", "fail");
				model.addAttribute("listmilkteas", this.getList());
				return "user/cart";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@GetMapping("/delete")
	public String delete(ModelMap model, @RequestParam("idMilkTea") int idMilkTea, @RequestParam("size") String size) {
		CartDetailId cartDetailId = new CartDetailId(3, idMilkTea, size);
		Optional<CartDetailEntity> cartDetail = cartDetailService.findById(cartDetailId);
		if (cartDetail.isPresent()) {
			CartDetailEntity cartDetailEntity = cartDetail.get();
			cartDetailService.delete(cartDetailEntity);
			model.addAttribute("listmilkteas", this.getList());
			return "redirect:/cart?status=success";
		} else {
			model.addAttribute("listmilkteas", this.getList());
			return "redirect:/cart?status=fail";
		}
	}
}
