package hcmute.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("admin")
public class MilkTeaTypeController {
	@GetMapping("view-milk-tea-type")
	public String IndexViewMilkTeaType() {
		return "admin/view/view-milk-tea-type";
	}
	@GetMapping("customize-milk-tea-type")
	public String IndexCustomizeMilkTeaType() {
		return "admin/customize/customize-milk-tea-type";
	}
}
