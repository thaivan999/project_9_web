package hcmute.controller.user;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hcmute.entity.MilkTeaEntity;
import hcmute.model.MilkTeaModel;
import hcmute.service.ICartDetailService;
import hcmute.service.IMilkTeaService;

@Controller
public class ProductsDetailController {
	@Autowired
	IMilkTeaService milkTeaService;
	@Autowired
	ICartDetailService cartDetailService;
	
	@GetMapping("product_detail/{id}")
	public ModelAndView detail(ModelMap model, @PathVariable("id") int id) {
		Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
		MilkTeaModel milkTeaModel = new MilkTeaModel();

		if (optMilkTea.isPresent()) {
			MilkTeaEntity entity = optMilkTea.get();
			
			// copy từ entity sang model
			BeanUtils.copyProperties(entity, milkTeaModel);
			milkTeaModel.setMilkTeaType(entity.getMilkTeaTypeByMilkTea().getName());
			milkTeaModel.setMilkTeaTypeId(entity.getMilkTeaTypeByMilkTea().getIdType());

			// chuyển model ra view
			model.addAttribute("milkTea", milkTeaModel);
			return new ModelAndView("user/product_detail", model);
		}
		
		// Sẽ làm trang hiển thị lỗi sau
		model.addAttribute("message", "Sản phẩm này không tồn tại");
		return new ModelAndView("forward:/admin/categories", model);
	}
	
	@GetMapping("/product_detail/buy")
	public String buyNow(ModelMap model, @RequestParam("id") int id, @RequestParam("size") String size, RedirectAttributes redirectAttributes) {
	    Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
	    MilkTeaModel milkTeaModel = new MilkTeaModel();

	    if (optMilkTea.isPresent()) {
	        MilkTeaEntity entity = optMilkTea.get();
	        
	        // copy từ entity sang model
	        BeanUtils.copyProperties(entity, milkTeaModel);
	        milkTeaModel.setSize(size);

	        // Chuyển hướng đến trang /payment và truyền model thông qua RedirectAttributes
	        redirectAttributes.addFlashAttribute("milkTea", milkTeaModel);
	        return "redirect:/payment";
	    }
	    
	    // Sẽ làm trang hiển thị lỗi sau
	    model.addAttribute("message", "Sản phẩm này không tồn tại");
	    return "forward:/admin/categories";
	}
	
	@GetMapping("/product_detail/addtocart")
	public ModelAndView addToCart(ModelMap model, @RequestParam("id") int id, @RequestParam("size") String size) {
		// thêm sản phẩm vào giỏ hàng
		// tạm để id cart là 1
		cartDetailService.addProductToCart(1, id, size);
		
		// load lại trang và hiển thị thông báo
		Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
		MilkTeaModel milkTeaModel = new MilkTeaModel();

		if (optMilkTea.isPresent()) {
			MilkTeaEntity entity = optMilkTea.get();
			
			// copy từ entity sang model
			BeanUtils.copyProperties(entity, milkTeaModel);
			milkTeaModel.setMilkTeaType(entity.getMilkTeaTypeByMilkTea().getName());

			// chuyển model ra view
			model.addAttribute("milkTea", milkTeaModel);
			model.addAttribute("message", "Thêm sản phẩm vào giỏ hàng thành công");
			return new ModelAndView("user/product_detail", model);
		}
		
		model.addAttribute("message", "Thêm sản phẩm vào giỏ hàng thất bại");
		return new ModelAndView("user/product_detail", model);
	}
}
