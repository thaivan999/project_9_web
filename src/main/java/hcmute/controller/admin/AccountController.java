package hcmute.controller.admin;

import java.util.List;
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

import hcmute.entity.AccountEntity;
import hcmute.model.AccountModel;
import hcmute.service.IAccountService;

@Controller
@RequestMapping("admin")
public class AccountController {
	@Autowired
	IAccountService accountService;
	@GetMapping("customize-account")
	public String IndexCustomizeAccount() {
		return "admin/customize/customize-account";
	}
	@GetMapping("view-account")
	public String IndexViewAccount(ModelMap model) {
		List<AccountEntity> account = accountService.findAll();
		model.addAttribute("account", account);
		return "admin/view/view-account";
	}
	@GetMapping("customize-account/add")
	public String Add(ModelMap model) {
		AccountModel account = new AccountModel();
		account.setIsEdit(false);
		model.addAttribute("account", account);
		return "admin/customize/customize-account";
	}
	@PostMapping("customize-account/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("account") AccountModel account, BindingResult result) {
	    if (result.hasErrors()) {
	        return new ModelAndView("admin/account/customize-account");
	    }
	    AccountEntity entity = new AccountEntity();
	    BeanUtils.copyProperties(account, entity);
	    accountService.save(entity);
	    String message = "";
	    if (account.getIsEdit()) {
	        message = "Account đã được cập nhật thành công";
	    } else {
	        message = "Book đã được thêm thành công";
	    }
	    model.addAttribute("message", message);
	    return new ModelAndView("forward:/admin/view-account", model);
	}
	@GetMapping("customize-account/edit/{idAccount}")
	public ModelAndView edit(ModelMap model, @PathVariable("idAccount") int idAccount) {
	    Optional<AccountEntity> opt = accountService.findById(idAccount);
	    AccountModel account = new AccountModel();
	    if(opt.isPresent()) {
	    	AccountEntity entity = opt.get();
	    	BeanUtils.copyProperties(entity, account);
	    	account.setIsEdit(true);
	    	model.addAttribute("account", account);
	    	return new ModelAndView("admin/account/customize-account", model);
	    }
	    model.addAttribute("message", "Account không tồn tại");
		return new ModelAndView("forward:/admin/view-account", model);
	}
}
