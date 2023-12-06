package hcmute.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("")
	
	public String showCategory(Model model) {
		List<MilkTeaCategoryEntity> categories = milkTeaCategoryService.findAll();
		List<List<MilkTeaTypeEntity>> types = new ArrayList<List<MilkTeaTypeEntity>>();
		model.addAttribute("categories", categories);
		for (MilkTeaCategoryEntity category : categories) {
			List<MilkTeaTypeEntity> categoriesWithTypes = milkTeaTypeService.findAllByCategoryId(category.getId());
			types.add(categoriesWithTypes);
		}
		model.addAttribute("types", types);
		List<MilkTeaEntity> milkTeas = milkTeaService.findAll();
	    model.addAttribute("milkTeas", milkTeas);
		return "user/products";
		
	}

	@RequestMapping("type/{id}")
	public String getMilkTeaByType(@PathVariable("id") Integer typeId, Model model) {
		List<MilkTeaCategoryEntity> categories = milkTeaCategoryService.findAll();
		List<List<MilkTeaTypeEntity>> types = new ArrayList<List<MilkTeaTypeEntity>>();
		model.addAttribute("categories", categories);
		for (MilkTeaCategoryEntity category : categories) {
			List<MilkTeaTypeEntity> categoriesWithTypes = milkTeaTypeService.findAllByCategoryId(category.getId());
			types.add(categoriesWithTypes);
		}
		model.addAttribute("types", types);
	    List<MilkTeaEntity> milkTeas = milkTeaService.findAllByTypeId(typeId);
	    model.addAttribute("milkTeas", milkTeas);
	    model.addAttribute("idActive", typeId);
	    return "user/products";
	}

}
