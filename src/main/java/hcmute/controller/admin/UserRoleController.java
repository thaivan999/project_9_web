package hcmute.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class UserRoleController {
	@GetMapping("view-user-role")
	public String IndexViewUserRole() {
		return "admin/view/view-user-role";
	}
	@GetMapping("customize-user-role")
	public String IndexCustomizeUserRole() {
		return "admin/customize/customize-user-role";
	}
}
