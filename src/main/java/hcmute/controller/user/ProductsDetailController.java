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
import hcmute.service.IMilkTeaService;

@Controller
public class ProductsDetailController {
	@Autowired
	IMilkTeaService milkTeaService;

	@GetMapping("product_detail/{id}")
	public ModelAndView detail(ModelMap model, @PathVariable("id") int id) {
		Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
		MilkTeaModel milkTeaModel = new MilkTeaModel();

		if (optMilkTea.isPresent()) {
			MilkTeaEntity entity = optMilkTea.get();
			
			// copy từ entity sang model
			BeanUtils.copyProperties(entity, milkTeaModel);
			milkTeaModel.setMilkTeaType(entity.getMilkTeaTypeByMilkTea().getName());

			// chuyển model ra view
			model.addAttribute("milktea", milkTeaModel);
			return new ModelAndView("user/product_detail", model);
		}
		
		// Sẽ làm trang hiển thị lỗi sau
		model.addAttribute("message", "Milktea product is not existed!!!!");
		return new ModelAndView("forward:/admin/categories", model);
	}
	
	@RequestMapping("/product_detail/buy")
	public String buyNow(ModelMap model, @RequestParam("id") int id, @RequestParam("size") String size, RedirectAttributes redirectAttributes) {
	    Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
	    MilkTeaModel milkTeaModel = new MilkTeaModel();

	    if (optMilkTea.isPresent()) {
	        MilkTeaEntity entity = optMilkTea.get();
	        
	        // copy từ entity sang model
	        BeanUtils.copyProperties(entity, milkTeaModel);
	        milkTeaModel.setSize(size);

	        // Chuyển hướng đến trang /payment và truyền model thông qua RedirectAttributes
	        redirectAttributes.addFlashAttribute("milktea", milkTeaModel);
	        return "redirect:/payment";
	    }
	    
	    // Sẽ làm trang hiển thị lỗi sau
	    model.addAttribute("message", "Milktea product is not existed!!!!");
	    return "forward:/admin/categories";
	}

}
