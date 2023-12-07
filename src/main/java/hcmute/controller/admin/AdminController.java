package hcmute.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.BranchEntity;
import hcmute.service.IBranchService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IOrderService;
import hcmute.service.IUserRoleService;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private IUserRoleService userRoleService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IMilkTeaService milkTeaService;
	
	@GetMapping("index")
	public String Index(ModelMap model) {
		int countUser = userRoleService.countUser();
		int countOrder = orderService.count();
		int countProduct = (int) milkTeaService.count();
		
		model.addAttribute("countUser", countUser );
		model.addAttribute("countOrder", countOrder);
		model.addAttribute("countProduct", countProduct);
		
		return "admin/index";
	}
}
