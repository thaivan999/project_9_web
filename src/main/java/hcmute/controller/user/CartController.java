package hcmute.controller.user;

import java.util.ArrayList;
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

import hcmute.embeddedId.CartDetailId;
import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.model.MilkTeaModel;
import hcmute.service.ICartDetailService;
import hcmute.service.IMilkTeaService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	ICartDetailService cartDetailService;
	
	@Autowired
	IMilkTeaService milkTeaService;
	
	private List<MilkTeaModel> getList() {
		List<Object[]> milkTeas = cartDetailService.findMilkTeaByCartId(1);
		List<MilkTeaModel> listmilkteas = new ArrayList<MilkTeaModel>();
		for(Object[] result : milkTeas) {
			MilkTeaEntity milktea = (MilkTeaEntity) result[0];
			String size = (String) result[1];
			MilkTeaModel milkTeaModel = new MilkTeaModel();
			BeanUtils.copyProperties(milktea, milkTeaModel);
			milkTeaModel.setSize(size);
			listmilkteas.add(milkTeaModel);
		}
		return listmilkteas;
	}

	@GetMapping("")
	public String list(ModelMap model, @RequestParam(value = "status", required = false) String status) {
		model.addAttribute("listmilkteas", this.getList());
		model.addAttribute("status", status);
		if(status != null) {
			if("success".equals(status)) {
				model.addAttribute("message", "Xóa thành công");
			} else {
				model.addAttribute("message", "Xóa thất bại");
			}
		}
		return "user/cart";
	}
	
	@GetMapping("/delete/{idMilkTea}")
	public String delete(ModelMap model, @PathVariable("idMilkTea") int idMilkTea) {
		CartDetailId cartDetailId = new CartDetailId(1, idMilkTea);
		Optional<CartDetailEntity> cartDetail = cartDetailService.findById(cartDetailId);
		if(cartDetail.isPresent()) {
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
