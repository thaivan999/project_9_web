package hcmute.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class UserOrderController {
	@GetMapping("view-user-order")
	public String IndexViewUserOrder() {
		return "admin/view/view-user-order";
	}
	@GetMapping("customize-user-order")
	public String IndexCustomizeUserOrder() {
		return "admin/customize/customize-user-order";
	}
}
