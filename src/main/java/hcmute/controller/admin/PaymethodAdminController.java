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

import hcmute.entity.PayMethodEntity;
import hcmute.model.PayMethodModel;
import hcmute.service.IPayMethodService;

@Controller
@RequestMapping("admin")
public class PaymethodAdminController {

	@Autowired
	private IPayMethodService payMethodService;

	@GetMapping("view-paymethod")
	public String IndexViewMethod(ModelMap model) {
		List<PayMethodEntity> payMethod = payMethodService.findAll();
		model.addAttribute("payMethod", payMethod);
		return "admin/view/view-paymethod";
	}

	@GetMapping("customize-paymethod")
	public String IndexCustomizePayMehthod() {
		return "admin/customize/customize-paymethod";
	}

	@GetMapping("customize-paymethod/add")
	public String add(ModelMap model) {
		PayMethodModel payMethod = new PayMethodModel();
		payMethod.setIsEdit(false);
		model.addAttribute("payMethod", payMethod);
		return "admin/customize/customize-paymethod";
	}

	@PostMapping("customize-paymethod/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("payMethod") PayMethodModel payMethod,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/customize/customize-paymethod");
		}
		if (payMethod != null) {
			PayMethodEntity entity = new PayMethodEntity();
			if (payMethod.getIdPayMethod() != null) {
				entity.setIdPayMethod(payMethod.getIdPayMethod());
			}
			if (payMethod.getName() != null) {
				entity.setName(payMethod.getName());
			}

			payMethodService.save(entity);
			String message = payMethod.getIsEdit() ? "paymethod đã được cập nhật thành công"
					: "paymethod đã được thêm thành công";
			model.addAttribute("message", message);
		} else {
			model.addAttribute("message", "Không thể lưu paymethod với dữ liệu null");
		}

		return new ModelAndView("redirect:/admin/view-paymethod", model);
	}

	@GetMapping("customize-paymethod/saveOrUpdate/{idPayMethod}")
	public ModelAndView edit(ModelMap model, @PathVariable("idPayMethod") String idPayMethod) {
		Optional<PayMethodEntity> opt = payMethodService.findById(idPayMethod);
		PayMethodModel payMethod = new PayMethodModel();
		if (opt.isPresent()) {
			PayMethodEntity entity = opt.get();
			BeanUtils.copyProperties(entity, payMethod);
			payMethod.setIsEdit(true);
			model.addAttribute("payMethod", payMethod);
			return new ModelAndView("admin/customize/customize-paymethod", model);
		}
		model.addAttribute("message", "paymethod không tồn tại");
		return new ModelAndView("forward:/admin/view-paymethod", model);
	}
}
