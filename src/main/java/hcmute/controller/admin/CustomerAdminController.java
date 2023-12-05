package hcmute.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("admin")
public class CustomerAdminController {
	@GetMapping("view-customer")
	public String IndexViewCustomer() {
		return "admin/view/view-customer";
	}
	@GetMapping("customize-customer")
	public String IndexCustomizeCustomer() {
		return "admin/customize/customize-customer";
	}
}
