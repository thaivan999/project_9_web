package hcmute.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.AccountEntity;
import hcmute.entity.BranchEntity;
import hcmute.model.AccountModel;
import hcmute.service.IAccountService;
import hcmute.service.IBranchService;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	IAccountService accountService;
	IBranchService branchService;
	@GetMapping("index")
	public String Index() {
		return "admin/index";
	}
	@GetMapping("view-account")
	public String IndexViewAccount(ModelMap model) {
		List<AccountEntity> account = accountService.findAll();
		model.addAttribute("account", account);
		return "admin/view/view-account";
	}
	
	@GetMapping("customize-branch")
	public String IndexCustomizeBranch() {
		return "admin/customize/customize-branch";
	}
	@GetMapping("view-cart")
	public String IndexViewCart() {
		return "admin/view/view-cart";
	}
	@GetMapping("customize-cart")
	public String IndexCustomizeCart() {
		return "admin/customize/customize-cart";
	}
	@GetMapping("view-cart-detail")
	public String IndexViewCartDetail() {
		return "admin/view/view-cart-detail";
	}
	@GetMapping("customize-cart-detail")
	public String IndexCustomizeCartDetail() {
		return "admin/customize/customize-cart-detail";
	}
	@GetMapping("view-customer")
	public String IndexViewCustomer() {
		return "admin/view/view-customer";
	}
	@GetMapping("customize-customer")
	public String IndexCustomizeCustomer() {
		return "admin/customize/customize-customer";
	}
	@GetMapping("view-milk-tea-type")
	public String IndexViewMilkTeaType() {
		return "admin/view/view-milk-tea-type";
	}
	@GetMapping("customize-milk-tea-type")
	public String IndexCustomizeMilkTeaType() {
		return "admin/customize/customize-milk-tea-type";
	}
	@GetMapping("view-milk-tea")
	public String IndexViewMilkTea() {
		return "admin/view/view-milk-tea";
	}
	@GetMapping("customize-milk-tea")
	public String IndexCustomizeMilkTea() {
		return "admin/customize/customize-milk-tea";
	}
	@GetMapping("view-milk-tea-category")
	public String IndexViewMilkTeaCategory() {
		return "admin/view/view-milk-tea-category";
	}
	@GetMapping("customize-milk-tea-category")
	public String IndexCustomizeMilkTeaCategory() {
		return "admin/customize/customize-milk-tea-category";
	}
	@GetMapping("view-order-detail")
	public String IndexViewOrderDetail() {
		return "admin/view/view-order-detail";
	}
	@GetMapping("customize-order-detail")
	public String IndexCustomizeOrderDetail() {
		return "admin/customize/customize-order-detail";
	}
	@GetMapping("view-paymethod")
	public String IndexViewMethod() {
		return "admin/view/view-paymethod";
	}
	@GetMapping("customize-paymethod")
	public String IndexCustomizePayMehthod() {
		return "admin/customize/customize-paymethod";
	}
	@GetMapping("view-user-order")
	public String IndexViewUserOrder() {
		return "admin/view/view-user-order";
	}
	@GetMapping("customize-user-order")
	public String IndexCustomizeUserOrder() {
		return "admin/customize/customize-user-order";
	}
	@GetMapping("view-user-role")
	public String IndexViewUserRole() {
		return "admin/view/view-user-role";
	}
	@GetMapping("customize-user-role")
	public String IndexCustomizeUserRole() {
		return "admin/customize/customize-user-role";
	}
}
