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

import hcmute.entity.MilkTeaTypeEntity;
import hcmute.model.MilkTeaTypeModel;
import hcmute.service.IMilkTeaTypeService;

@Controller
@RequestMapping("admin")
public class MilkTeaTypeAdminController {

	@Autowired
	private IMilkTeaTypeService milkTeaTypeService;

	@GetMapping("view-milk-tea-type")
	public String IndexViewMilkTeaType(ModelMap model) {
		List<MilkTeaTypeEntity> milkTeaTypes = milkTeaTypeService.findAll();
		model.addAttribute("milkTeaTypes", milkTeaTypes);
		return "admin/view/view-milk-tea-type";
	}

	@GetMapping("customize-milk-tea-type")
	public String IndexCustomizeMilkTeaType() {
		return "admin/customize/customize-milk-tea-type";
	}

	@GetMapping("customize-milk-tea-type/add")
	public String add(ModelMap model) {
		MilkTeaTypeModel milkTeaType = new MilkTeaTypeModel();
		milkTeaType.setIsEdit(false);
		model.addAttribute("milkTeaType", milkTeaType);
		return "admin/customize/customize-milk-tea-type";
	}

	@PostMapping("customize-milk-tea-type/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("milkTeaType") MilkTeaTypeModel milkTeaType,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/customize/customize-milk-tea-type");
		}
		if (milkTeaType != null) {
            MilkTeaTypeEntity entity = new MilkTeaTypeEntity();
            if (milkTeaType.getIdType() != 0) {
                entity.setIdType(milkTeaType.getIdType());
            }
            if (milkTeaType.getName() != null) {
                entity.setName(milkTeaType.getName());
            }
            milkTeaTypeService.save(entity);
            String message = milkTeaType.getIsEdit() ? "milkTeaType đã được cập nhật thành công" : "milkTeaType đã được thêm thành công";
            model.addAttribute("message", message);
        } else {
            model.addAttribute("message", "Không thể lưu milkTeaType với dữ liệu null");
        }
		
		
		/*
		 * MilkTeaTypeEntity entity = new MilkTeaTypeEntity();
		 * BeanUtils.copyProperties(milkTeaType, entity);
		 * milkTeaTypeService.save(entity); String message = ""; if
		 * (milkTeaType.getIsEdit() == true) { message =
		 * "milkTeaType đã được cập nhật thành công"; } else { message =
		 * "milkTeaType đã được thêm thành công"; } model.addAttribute("message",
		 * message);
		 */
		return new ModelAndView("redirect:/admin/view-milk-tea-type", model);
	}

	@GetMapping("customize-milk-tea-type/saveOrUpdate/{idType}")
	public ModelAndView edit(ModelMap model, @PathVariable("idType") int idType) {
		Optional<MilkTeaTypeEntity> opt = milkTeaTypeService.findById(idType);
		MilkTeaTypeModel milkTeaType = new MilkTeaTypeModel();
		if (opt.isPresent()) {
			MilkTeaTypeEntity entity = opt.get();
			BeanUtils.copyProperties(entity, milkTeaType);
			milkTeaType.setIsEdit(true);
			model.addAttribute("milkTeaType", milkTeaType);
			return new ModelAndView("admin/customize/customize-milk-tea-type", model);
		}
		model.addAttribute("message", "milkTeaType không tồn tại");
		return new ModelAndView("forward:/admin/view-milk-tea-type", model);
	}
}
