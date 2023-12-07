package hcmute.controller.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.CustomerEntity;
import hcmute.service.ICustomerService;

@Controller
@RequestMapping("user_infor")
public class UserInfoController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/{user_id}")
    public String viewCustomer(ModelMap model, @PathVariable("user_id") Integer id) {
        Optional<CustomerEntity> customerOptional = customerService.findById(id);

        if (customerOptional.isPresent()) {
            CustomerEntity customer = customerOptional.get();
            model.addAttribute("customer", customer);
            return "user/user_infor";
        } else {
            model.addAttribute("message", "Không tìm thấy thông tin khách hàng với ID: " + id);
            return "error"; // Trả về trang lỗi 
        }
    }
    
    @PostMapping("/{user_id}/update")
    public String updateCustomer(ModelMap model, @PathVariable("user_id") Integer id, CustomerEntity updatedCustomer) {
        Optional<CustomerEntity> customerOptional = customerService.findById(id);

        if (customerOptional.isPresent()) {
            CustomerEntity existingCustomer = customerOptional.get();

            // Cập nhật thông tin khách hàng
            existingCustomer.setSurname(updatedCustomer.getSurname());
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            existingCustomer.setBirthday(updatedCustomer.getBirthday());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setGender(updatedCustomer.getGender());

            // Lưu thông tin cập nhật vào cơ sở dữ liệu
            customerService.updateCustomer(existingCustomer);

            // Load lại trang thông tin khách hàng
            return "redirect:/user_infor/" + id;
        } else {
            model.addAttribute("message", "Không tìm thấy thông tin khách hàng với ID: " + id);
            return "error";
        }
    }
}