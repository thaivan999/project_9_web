package hcmute.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
	@GetMapping("index")
	public String Index() {
		return "admin/index";
	}
	@GetMapping("view-user")
	public String IndexViewUser() {
		return "admin/view-user";
	}
	@GetMapping("customize-user")
	public String IndexCustomizeUser() {
		return "admin/customize-user";
	}
}
