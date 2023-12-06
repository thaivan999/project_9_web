package hcmute.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.MilkTeaEntity;
import hcmute.service.IMilkTeaCategoryService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IMilkTeaTypeService;

@Controller
@RequestMapping("header")
public class HeaderController {
	@Autowired
	IMilkTeaCategoryService milkTeaCategoryService;
	@Autowired
	IMilkTeaTypeService milkTeaTypeService;
	@Autowired
	IMilkTeaService milkTeaService;
	
	private List<MilkTeaEntity> milkTeas;
	
	@GetMapping("/search")
	public String showCategory(Model model) {
		milkTeas = milkTeaService.findAll();
	    model.addAttribute("milkTeas", milkTeas);
		return "user/search";
		
	}
	
	@RequestMapping("search/content={name}")
	public String getMilkTeaByNameContaining(@PathVariable("name") String name, Model model) {
	    milkTeas = milkTeaService.findByNameContaining(name);
//		milkTeas = milkTeaService.findByNameContainingAndSortAscendingByCost(name);
//	    milkTeas = milkTeaService.findByNameContainingAndSortDescendingByCost(name);
	    model.addAttribute("milkTeas", milkTeas);
	    return "user/search";
	}
	
	@RequestMapping("search/content={name}/method={method}")
	public String searchAndSort(@PathVariable("name") String name, @PathVariable("method") String method, Model model) {
	    if ("newness".equals(method)) {
	    	
	    }
	    else if ("outstanding".equals(method)) {
	    	
	    }
	    else if ("low-to-high".equals(method)) {
	    	milkTeas = milkTeaService.findByNameContainingAndSortAscendingByCost(name);
	    	System.out.println("low-to-high");
	    }
	    else if ("high-to-low".equals(method)) {
	    	milkTeas = milkTeaService.findByNameContainingAndSortDescendingByCost(name);
	    	System.out.println("high-to-low");
	    }
	    
	    model.addAttribute("milkTeas", milkTeas);
	    return "user/search";
	}

}
