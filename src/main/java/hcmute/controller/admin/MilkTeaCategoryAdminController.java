package hcmute.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.model.BranchModel;

import hcmute.model.MilkTeaCategoryModel;

import hcmute.service.IMilkTeaCategoryService;


public class MilkTeaCategoryAdminController {
	@Autowired
    private IMilkTeaCategoryService milkTeaCategoryService;

    @GetMapping("")
    public String indexViewCity(ModelMap model) {
        List<MilkTeaCategoryEntity> milkteacategory = milkTeaCategoryService.findAll();
        model.addAttribute("milkcategory", milkteacategory);  // Updated attribute name to "branches"
        return "admin/view/view-milk-tea-category";
    }

    @GetMapping("add")
    public String add(ModelMap model) {
        MilkTeaCategoryModel milkteacategory = new MilkTeaCategoryModel();
        model.addAttribute("milkteacategory", milkteacategory);
        return "admin/customize/customize-milk-tea-category";
    }
    
    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("milkteacategory") BranchModel milkteacategory, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("admin/customize/customize-milk-tea-category");
        }
        if (milkteacategory != null) {
            MilkTeaCategoryEntity entity = new MilkTeaCategoryEntity();
           
            milkTeaCategoryService.save(entity);
            String message = milkteacategory.getIsEdit() ? "MilkTeaCategory đã được cập nhật thành công" : "MilkTeaCategory đã được thêm thành công";
            model.addAttribute("message", message);
        } else {
            model.addAttribute("message", "Không thể lưu MilkTeaCategory với dữ liệu null");
        }

        return new ModelAndView("redirect:/admin/milkteacategory", model);
    }

    @GetMapping("edit/{idMilkTeaCategory}")
    public ModelAndView edit(ModelMap model, @PathVariable("idMilkTeaCategory") int idMilkTeaCategory) {
        Optional<MilkTeaCategoryEntity> opt = milkTeaCategoryService.findById(idMilkTeaCategory);
        MilkTeaCategoryModel milkteacategory = new MilkTeaCategoryModel();
        if (opt.isPresent()) {
            MilkTeaCategoryEntity entity = opt.get();
            BeanUtils.copyProperties(entity, milkteacategory);
            model.addAttribute("milkteacategory", milkteacategory);
            return new ModelAndView("admin/customize/customize-milk-tea-category", model);
        }

        model.addAttribute("message", "MilkTeaCategory không tồn tại");
        return new ModelAndView("forward:/admin/milkteacategory", model);
    }
}
