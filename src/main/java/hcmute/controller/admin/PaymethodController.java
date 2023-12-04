package hcmute.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class PaymethodController {
	@GetMapping("view-paymethod")
	public String IndexViewMethod() {
		return "admin/view/view-paymethod";
	}
	@GetMapping("customize-paymethod")
	public String IndexCustomizePayMehthod() {
		return "admin/customize/customize-paymethod";
	}
}
