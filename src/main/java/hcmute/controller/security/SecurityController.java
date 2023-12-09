package hcmute.controller.security;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.MilkTeaEntity;
import hcmute.entity.UserEntity;
import hcmute.model.AuthProvider;
import hcmute.repository.UserRepository;
import hcmute.service.IForgotPasswordService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IUserService;
import hcmute.service.impl.CookieServiceImpl;
import hcmute.service.impl.SessionServiceImpl;
import hcmute.utils.CommonUtils;
import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("security")
@SessionAttributes("user")
public class SecurityController {
	@Autowired
	IUserService userService;
	@Autowired
	UserRepository repo;

	@Autowired
	IForgotPasswordService passService;
	@Autowired
	CookieServiceImpl cookieService;
	@Autowired
	SessionServiceImpl sessionService;

	@GetMapping("change-password")
	public String showResetPasswordForm(@RequestParam("token") String token, ModelMap model) {
		UserEntity user = passService.getByResetPasswordToken(token);
		model.addAttribute("token", token);
		if (user == null) {
			model.addAttribute("message", "Invalid Token");
		}
		return "security/change-password/change-password";
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
	public String IndexRegister(ModelMap model) {
		return "security/register/register";
	}

	@PostMapping("login")
	public String login(ModelMap model, @RequestParam String username, HttpServletRequest req, HttpSession session)
			throws MessagingException {
		username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember-me");
		Optional<UserEntity> user = userService.findByUsername(username);
//	    sessionService.setAttribute("user", user);
		model.addAttribute("user", user);
		cookieService.Add("username", username, 1);
		cookieService.Add("password", password, 1);
		model.addAttribute("username", cookieService.getValue("username"));
		model.addAttribute("password", cookieService.getValue("password"));
		return "redirect:/security/login";
	}

	@GetMapping("unauthorized")
	public String unauthoried(Model model) {
		model.addAttribute("message", "Access denied!");
		return "security/login/login";
	}

	@PostMapping("register")
	public String register(Model model, @ModelAttribute UserEntity user, HttpServletRequest req)
			throws MessagingException {
		Optional<UserEntity> existUserByEmail = userService.findByEmail(user.getEmail());
		Optional<UserEntity> existUserByUsername = userService.findByUsername(user.getUsername());
		if (existUserByEmail.isPresent()) {
			model.addAttribute("message", "User with email " + user.getEmail() + " is already registered");
			return "security/register/register";
		}
		if (existUserByUsername.isPresent()) {
			model.addAttribute("message", "User with username " + user.getUsername() + " is already registered");
			return "security/register/register";
		}
		userService.register(user, CommonUtils.getSiteURL(req));
		model.addAttribute("message", "Please check your email to verify your account");
		return "security/register/register";
	}

	@GetMapping("verify")
	public String verifyAcc(Model model, @RequestParam String code) {
		if (userService.verify(code)) {
			model.addAttribute("message", "Xác thực thành công");
			return "redirect:/security/login";
		} else {
			model.addAttribute("message", "Xác thực thất bại");
			return "security/security/login";
		}
	}

	@PostMapping("forgot-password")
	public ModelAndView postsend(ModelMap model, HttpServletRequest req) throws MessagingException {
		String email = req.getParameter("forgotEmail");
		String token = RandomString.make(30);
		UserEntity user = repo.findByEmail(email).orElse(null);
		if (!repo.existsUserByEmail(email)) {
			model.addAttribute("message", "Email not existed!!");
			return new ModelAndView("security/forgot-password/forgot-password", model);
		}
		if (user.getProvider() != AuthProvider.DATABASE) {
			model.addAttribute("message", "Can't recover account!!");
			return new ModelAndView("security/forgot-password/forgot-password", model);
		}

		try {
			passService.updateResetPasswordToken(token, email);
			String resetPasswordLink = CommonUtils.getSiteURL(req) + "/security/forgot-password?token=" + token;
			passService.sendEmail(email, resetPasswordLink);
			model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
			System.out.println("""


					We have sent a reset password link to your email. Please check.


					""");
			System.out.println("Forgot Email: " + email);
		} catch (Exception e) {
			model.addAttribute("message", "Something went wrong. Please try again later.");
		}
		return new ModelAndView("redirect:/", model);
	}

	@PostMapping("change-password")
	public ModelAndView processResetPassword(HttpServletRequest request, ModelMap model) {
		String token = request.getParameter("token");
		System.out.println(token);
		String password = request.getParameter("password");
		UserEntity user = passService.getByResetPasswordToken(token);
		if (user == null) {
			model.addAttribute("message", "Invalid Token");
			System.out.println("Invalid Token");
			return new ModelAndView("redirect:/", model);
		} else {
			passService.updatePassword(user, password);
			System.out.println("You have successfully changed your password.");
			model.addAttribute("message", "You have successfully changed your password.");
		}
		return new ModelAndView("redirect:/", model);
	}

	@GetMapping("logout")
	public String logoffSuccess(Model model, HttpSession session) {
		model.addAttribute("message", "You have log out!");
		session.removeAttribute("username");
		return "security/login/login";
	}

}
