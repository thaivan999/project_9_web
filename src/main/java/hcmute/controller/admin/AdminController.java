package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import hcmute.entity.BranchEntity;
import hcmute.entity.UserEntity;
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
	public String Index(ModelMap model) throws JsonProcessingException {
		int countUser = userRoleService.countUser();
		int countOrder = orderService.count();
		int countProduct = (int) milkTeaService.count();
		
		model.addAttribute("countUser", countUser );
		model.addAttribute("countOrder", countOrder);
		model.addAttribute("countProduct", countProduct);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		
        List<Object[]> revenueDataByDay = orderService.getRevenueByDay();
        String revenueDataByDayJson = objectMapper.writeValueAsString(revenueDataByDay);
        
        List<Object[]> revenueDataByMonth = orderService.getRevenueByMonth();
        String revenueDataByMonthJson = objectMapper.writeValueAsString(revenueDataByMonth);
        
        model.addAttribute("revenueDataByDayJson", revenueDataByDayJson);
        model.addAttribute("revenueDataByMonthJson", revenueDataByMonthJson);
		
		return "admin/index";
	}

}
