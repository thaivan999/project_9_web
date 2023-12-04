package hcmute.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.MilkTeaTypeEntity;

import hcmute.service.IMilkTeaCategoryService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IMilkTeaTypeService;

@Controller
@RequestMapping("products")
public class ProductsController {

	@Autowired
	IMilkTeaCategoryService milkTeaCategoryService;
	@Autowired
	IMilkTeaTypeService milkTeaTypeService;
	@Autowired
	IMilkTeaService milkTeaService;

	@RequestMapping("")
	public String showCategory(Model model, Integer id_category) {
		List<MilkTeaCategoryEntity> categories = milkTeaCategoryService.findAll();
		List<MilkTeaTypeEntity> categoriesWithTypes = milkTeaTypeService.findAllByColumn(id_category);
		model.addAttribute("categories", categories);
		model.addAttribute("categoriesWithTypes", categoriesWithTypes);
		return "user/products";
	}

	@RequestMapping("type/{Id}")
	public String getMilkTeaByType(@PathVariable Integer typeId, Model model) {
		List<MilkTeaEntity> milkTeas = milkTeaService.findAllByColumn(typeId);
		model.addAttribute("milkTeas", milkTeas);
		return "user/products";
	}

}
