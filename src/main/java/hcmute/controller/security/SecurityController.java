package hcmute.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("security")
public class SecurityController {
	@GetMapping("change_password")
	public String IndexChangePassword() {
		return "security/change_password/change_password";
	}
	@GetMapping("edit_account")
	public String IndexEditAccount() {
		return "security/edit_account/edit_account";
	}
	@GetMapping("forgot_password")
	public String IndexForgotPassword() {
		return "security/forgot_password/forgot_password";
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
