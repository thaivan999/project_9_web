package hcmute.controller.user;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.view.RedirectView;

import hcmute.entity.MilkTeaEntity;
import hcmute.model.MilkTeaModel;
import hcmute.service.ICartDetailService;
import hcmute.service.IMilkTeaService;

@Controller
@RequestMapping("product_detail")
public class ProductsDetailController {
	@Autowired
	IMilkTeaService milkTeaService;
	@Autowired
	ICartDetailService cartDetailService;
	
	@GetMapping("/{id}")
	public ModelAndView detail(ModelMap model, @PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
		MilkTeaModel milkTeaModel = new MilkTeaModel();

		if (optMilkTea.isPresent()) {
			MilkTeaEntity entity = optMilkTea.get();
			
			// copy from entity to model
			BeanUtils.copyProperties(entity, milkTeaModel);
			int typeId = entity.getMilkTeaTypeByMilkTea().getIdType();
			
			// set attributes for model
			milkTeaModel.setMilkTeaType(entity.getMilkTeaTypeByMilkTea().getName());
			milkTeaModel.setMilkTeaTypeId(typeId);
			
			List<MilkTeaEntity> relevantProducts = milkTeaService.findRelevantProducts(typeId, id);

			// get flash attributes from previous request 
	        String cartMessage = (String) redirectAttributes.getFlashAttributes().get("cartMessage");
			
			if (cartMessage != null) {
				model.addAttribute("cartMessage", cartMessage);
			}
			
			model.addAttribute("milkTea", milkTeaModel);
			model.addAttribute("relevantProducts", relevantProducts);
			
			return new ModelAndView("user/product_detail", model);
		}
		
		model.addAttribute("message", "Sản phẩm này không tồn tại");
		return new ModelAndView("user/error", model);
	}
	
	@GetMapping("/addtocart")
	public RedirectView addToCart(RedirectAttributes redirectAttributes, @RequestParam("id") int id, @RequestParam("size") String size) {
	    
		try {
	    	// tạm để id cart là 1
		    cartDetailService.addProductToCart(1, id, size);
		    redirectAttributes.addFlashAttribute("cartMessage", "success");
		} catch (Exception e) {
			 redirectAttributes.addFlashAttribute("cartMessage", "fail");
		}

	    // redirect
	    return new RedirectView("/product_detail/" + id);
	}
}
