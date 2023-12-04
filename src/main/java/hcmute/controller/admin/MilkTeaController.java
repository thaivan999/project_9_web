package hcmute.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("admin")
public class MilkTeaController {
	@GetMapping("view-milk-tea")
	public String IndexViewMilkTea() {
		return "admin/view/view-milk-tea";
	}
	@GetMapping("customize-milk-tea")
	public String IndexCustomizeMilkTea() {
		return "admin/customize/customize-milk-tea";
	}
}
