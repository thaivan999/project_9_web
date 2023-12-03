package hcmute.controller.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.service.ICartDetailService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	ICartDetailService cartDetailService;

	@GetMapping("")
	public String list(ModelMap model) {
		List<MilkTeaEntity> milkTeas = cartDetailService.findMilkTeaByCartId(1);
		model.addAttribute("listmilktea", milkTeas);
		return "user/cart";
	}
}
