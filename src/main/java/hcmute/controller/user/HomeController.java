package hcmute.controller.user;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hcmute.entity.MilkTeaEntity;
import hcmute.entity.UserEntity;
import hcmute.service.IMilkTeaService;
import hcmute.service.impl.SessionServiceImpl;

@Controller
@RequestMapping("home")
@SessionAttributes("user")
public class HomeController {
	@Autowired
	IMilkTeaService milkTeaService;

	@GetMapping("")
	public String LoadData(ModelMap model, HttpSession session) {
		List<MilkTeaEntity> list1 = milkTeaService.findFiveProductOutstanding();
		model.addAttribute("list1", list1);
		List<MilkTeaEntity> list2 = milkTeaService.findFiveProduct();
		model.addAttribute("list2", list2);
		return "user/home";
	}
}
