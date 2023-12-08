//package hcmute.controller.admin;
//
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import hcmute.entity.CustomerEntity;
//import hcmute.model.BranchModel;
//
//import hcmute.model.CustomerModel;
//import hcmute.service.ICustomerService;
//@Controller
//@RequestMapping("admin")
//public class CustomerAdminController {
//	@Autowired
//	private ICustomerService customerService;
//	
//	@GetMapping("view-customer")
//	public String IndexViewCustomer() {
//		return "admin/view/view-customer";
//	}
//	@GetMapping("customize-customer")
//	public String IndexCustomizeCustomer() {
//		return "admin/customize/customize-customer";
//	}
//	
//	@GetMapping("add")
//	public String add(ModelMap model) {
//		CustomerModel customer = new CustomerModel();
//		model.addAttribute("customer", customer);
//		return "admin/customize/customize-customer.jsp";
//	}
//	
//	@PostMapping("saveOrUpdate")
//	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("customer") BranchModel customer, BindingResult result) {
//		if (result.hasErrors()) {
//			return new ModelAndView("admin/customize/customize-customer.jsp");
//		}
//		if (customer != null) {
//			CustomerEntity entity = new CustomerEntity();
////			customerService.updateCustomer(entity);
//			String message = customer.getIsEdit() ? "City đã được cập nhật thành công" : "City đã được thêm thành công";
//			model.addAttribute("message", message);
//		} else {
//			model.addAttribute("message", "Không thể lưu City với dữ liệu null");
//		}
//		return new ModelAndView("redirect:/admin/customer", model);
//	}
//	
//	@GetMapping("edit/{idCustomer}")
//	public ModelAndView edit(ModelMap model, @PathVariable("idCustomer") int idCustomer) {
//        Optional<CustomerEntity> opt = customerService.findById(idCustomer);
//        CustomerModel customer = new CustomerModel();
//        if (opt.isPresent()) {
//            CustomerEntity entity = opt.get();
//            BeanUtils.copyProperties(entity, customer);
//            model.addAttribute("customer", customer);
//            return new ModelAndView("admin/customize/customize-customer", model);
//        }
//
//        model.addAttribute("message", "Customer không tồn tại");
//        return new ModelAndView("forward:/admin/customer", model);
//    }
//}
