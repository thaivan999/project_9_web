package hcmute.controller.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
	public String getMilkTeaByNameContaining(@PathVariable("name") String encodedName, Model model) {
	    try {
	        String name = URLDecoder.decode(encodedName, StandardCharsets.UTF_8.toString());
	        milkTeas = milkTeaService.findByNameContaining(name);
	        model.addAttribute("milkTeas", milkTeas);
	        return "user/search";
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return "error";
	    }
	}
	
	@RequestMapping("search/content={name}/method={method}")
	public String searchAndSort(@PathVariable("name") String encodedName, @PathVariable("method") String method, Model model) {
		try {
			 String name = URLDecoder.decode(encodedName, StandardCharsets.UTF_8.toString());
			if ("outstanding".equals(method)) {
		    	
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
		catch(UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return "error";
		}
	}
	
	@GetMapping("/moveToSearchPage")
	public RedirectView moveToSearchPage(RedirectAttributes redirectAttributes, @RequestParam("content") String content) {
		try {
	        String encodedContent = URLEncoder.encode(content, StandardCharsets.UTF_8.toString());
	        return new RedirectView("/header/search/content=" + encodedContent);
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return new RedirectView("/error");
	    }
	}

}
