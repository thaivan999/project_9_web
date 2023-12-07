package hcmute.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.BranchEntity;
import hcmute.service.IBranchService;

@Controller
@RequestMapping("admin")
public class AdminController {
	@GetMapping("index")
	public String Index() {
		return "admin/index";
	}
}
