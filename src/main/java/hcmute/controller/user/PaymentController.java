package hcmute.controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.CustomerEntity;
import hcmute.entity.PayMethodEntity;
import hcmute.service.ICustomerService;
import hcmute.service.IOrderDetailService;
import hcmute.service.IOrderService;
import hcmute.service.IPayMethodService;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	IOrderService orderService;
	
	@Autowired
	IOrderDetailService orderDetailService;
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	IPayMethodService payMethodService;
	
	@GetMapping("")
	private String displayPayment(ModelMap model)
	{
		List<PayMethodEntity> listPayMethod = payMethodService.findAll();
		model.addAttribute("listPayMethod", listPayMethod);
		
		Optional<CustomerEntity> optCustomer = customerService.findById(1);
		if(optCustomer.isPresent())
		{
			CustomerEntity customer = optCustomer.get();
			model.addAttribute("customer", customer);
		}
		return "user/payment";
	}

//	@PostMapping("/Order")
//	private ModelAndView insertOrder(ModelMap model, @AddAttribute OrderModel orderModel)
//	{
//		
//	}
}
