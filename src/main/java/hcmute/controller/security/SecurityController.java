package hcmute.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("security")
public class SecurityController {
	@GetMapping("change-password")
	public String IndexChangePassword() {
		return "security/change-password/change-password";
	}
	@GetMapping("edit-account")
	public String IndexEditAccount() {
		return "security/edit-account/edit-account";
	}
	@GetMapping("forgot-password")
	public String IndexForgotPassword() {
		return "security/forgot-password/forgot-password";
	}
	@GetMapping("login")
	public String IndexLogin() {
		return "security/login/login";
	}
	@GetMapping("register")
	public String IndexRegister() {
		return "security/register/register";
	}
}
