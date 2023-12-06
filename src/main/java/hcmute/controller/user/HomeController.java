package hcmute.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.MilkTeaEntity;
import hcmute.service.IMilkTeaService;

@Controller
@RequestMapping("home")
public class HomeController {
	@Autowired
	IMilkTeaService milkTeaService;
	
	@GetMapping("")
	public String LoadData(ModelMap model) {
		List<MilkTeaEntity> list1 = milkTeaService.findFiveProductOutstanding();
		model.addAttribute("list1", list1);
		List<MilkTeaEntity> list2 = milkTeaService.findFiveProduct();
		model.addAttribute("list2", list2);

		return "user/home";
	}
}
