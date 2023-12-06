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
	public ModelAndView detail(ModelMap model, @PathVariable("id") int id, HttpServletRequest request) {
		Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
		MilkTeaModel milkTeaModel = new MilkTeaModel();

		if (optMilkTea.isPresent()) {
			MilkTeaEntity entity = optMilkTea.get();
			
			// copy from entity to model
			BeanUtils.copyProperties(entity, milkTeaModel);
			int typeId = entity.getMilkTeaTypeByMilkTea().getIdType();
			
			milkTeaModel.setMilkTeaType(entity.getMilkTeaTypeByMilkTea().getName());
			milkTeaModel.setMilkTeaTypeId(typeId);
			
			List<MilkTeaEntity> relevantProducts = milkTeaService.findRelevantProducts(typeId, id);

			// get info from session
		    HttpSession session = request.getSession();
		    String cartMessage = (String) session.getAttribute("cartMessage");
			
			if (cartMessage != null) {
				model.addAttribute("cartMessage", cartMessage);
				session.removeAttribute("cartMessage"); 
			}
			
			model.addAttribute("milkTea", milkTeaModel);
			model.addAttribute("relevantProducts", relevantProducts);
			
			return new ModelAndView("user/product_detail", model);
		}
		
		// Sẽ làm trang hiển thị lỗi sau
		model.addAttribute("message", "Sản phẩm này không tồn tại");
		return new ModelAndView("forward:/admin/categories", model);
	}
	
	@GetMapping("/buy")
	public String buyNow(ModelMap model, @RequestParam("id") int id, @RequestParam("size") String size, HttpServletRequest request) {
	    Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
	    MilkTeaModel milkTeaModel = new MilkTeaModel();

	    if (optMilkTea.isPresent()) {
	        MilkTeaEntity entity = optMilkTea.get();
	        
	        // copy from entity to model
	        BeanUtils.copyProperties(entity, milkTeaModel);
	        milkTeaModel.setSize(size);

	        // redirect to /payment and send milk tea model
		    HttpSession session = request.getSession();
		    session.setAttribute("milkTea", milkTeaModel);
		    
	        return "redirect:/payment";
	    }
	    
	    // Sẽ làm trang hiển thị lỗi sau
	    model.addAttribute("message", "Sản phẩm này không tồn tại");
	    return "forward:/admin/categories";
	}
	
	@GetMapping("/addtocart")
	public RedirectView addToCart(HttpServletRequest request, @RequestParam("id") int id, @RequestParam("size") String size) {
	    HttpSession session = request.getSession();
	    
		try {
	    	// tạm để id cart là 1
		    cartDetailService.addProductToCart(1, id, size);
		    session.setAttribute("cartMessage", "success");
		} catch (Exception e) {
		    session.setAttribute("cartMessage", "fail");
		}

	    // redirect
	    return new RedirectView("/product_detail/" + id);
	}
}
