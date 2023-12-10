package hcmute.controller.user;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.UserEntity;
import hcmute.model.UserModel;
import hcmute.service.IUserService;

@Controller
@RequestMapping("user_infor")
public class UserInfoController {

	@Autowired
	IUserService userService;

	//code cũ chạy được mà sao giờ gộp 2 bảng xong hết chạy được
	
	@GetMapping("/{user_id}")
	public String viewuser(ModelMap model, @PathVariable("user_id") Integer userId) {
		Optional<UserEntity> opt = userService.findById(userId);
		
		if (opt.isPresent()) {
			UserEntity user = opt.get();
			model.addAttribute("user", user);
			return "user/user_infor";
		} else {
			model.addAttribute("message", "Không tìm thấy thông tin khách hàng với ID: " + userId);
			return "user/error";
		}
	}

	@PostMapping("/edit/{user_id}")
	public ModelAndView edit(ModelMap model, @PathVariable("user_id") Integer userId,
			@Valid @ModelAttribute("user") UserModel user, BindingResult result) {
//		if (result.hasErrors()) {
//			return new ModelAndView("user/error");
//		}
		if (user != null) {
			UserEntity entity = userService.findById(userId).get();
			if(entity.getPassword() == null) {
				entity.setPassword("");
			}
			if (user.getName() != "") {
				entity.setName(user.getName());
			}
			if (user.getSurname() != "") {
				entity.setSurname(user.getSurname());
			}
			if (user.getGender() == 1 || user.getGender() == 0) {
				entity.setGender(user.getGender());
			}

//			BeanUtils.copyProperties(user, entity);
			userService.save(entity);
			model.addAttribute("message", "Thông tin đã được cập nhật thành công!");
		} else {
			model.addAttribute("message", "Vui lòng không để trống thông tin!");
		}

		return new ModelAndView("redirect:/user_infor/" + userId);

	}

}