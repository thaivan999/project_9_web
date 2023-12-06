package hcmute.controller.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import hcmute.entity.CustomerEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.PayMethodEntity;
import hcmute.model.MilkTeaModel;
import hcmute.model.OrderProduct;
import hcmute.model.OrderProduct.OrderItem;
import hcmute.service.ICustomerService;
import hcmute.service.IMilkTeaService;
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
	
	@Autowired
	IMilkTeaService milkTeaService;
	
	@GetMapping("")
	private String displayPayment(ModelMap model, @RequestParam("data") String data) throws UnsupportedEncodingException
	{
		data = URLDecoder.decode(data, "UTF-8");
		List<PayMethodEntity> listPayMethod = payMethodService.findAll();
		model.addAttribute("listPayMethod", listPayMethod);
		
		Optional<CustomerEntity> optCustomer = customerService.findById(1);
		if(optCustomer.isPresent())
		{
			CustomerEntity customer = optCustomer.get();
			model.addAttribute("customer", customer);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			OrderProduct orderProduct = objectMapper.readValue(data, OrderProduct.class);
			List<MilkTeaModel> listMilkTea = new ArrayList<MilkTeaModel>();
			for(OrderItem item : orderProduct.getList())
			{
				Optional<MilkTeaEntity> entity = milkTeaService.findByIdMilkTea(Integer.parseInt(item.getIdMilkTea()));
				if(entity.isPresent()) {
					MilkTeaModel milkTeaModel = new MilkTeaModel();
					BeanUtils.copyProperties(entity.get(), milkTeaModel);
					milkTeaModel.setSize(item.getSize());
					milkTeaModel.setOrderQuantity(Integer.parseInt(item.getQuantity()));
					milkTeaModel.setCost(item.getPrice());
					listMilkTea.add(milkTeaModel);
				}
			}
			model.addAttribute("orderProduct", orderProduct);
			model.addAttribute("listMilkTea", listMilkTea);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "user/payment";
	}
	
	

//	@PostMapping("/Order")
//	private ModelAndView insertOrder(ModelMap model, @AddAttribute OrderModel orderModel)
//	{
//		
//	}
}
