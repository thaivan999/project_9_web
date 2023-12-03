package hcmute.controller.user;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.MilkTeaEntity;
import hcmute.model.MilkTeaModel;
import hcmute.service.IMilkTeaService;

@Controller
public class ProductsDetailController {
	@Autowired
	IMilkTeaService milkTeaService;

	@GetMapping("product_detail/{id}")
	public ModelAndView detail(ModelMap model, @PathVariable("id") int id) {
		Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
		MilkTeaModel milkTeaModel = new MilkTeaModel();

		if (optMilkTea.isPresent()) {
			MilkTeaEntity entity = optMilkTea.get();
			
			// copy từ entity sang model
			BeanUtils.copyProperties(entity, milkTeaModel);
			milkTeaModel.setMilkTeaType(entity.getMilkTeaTypeByMilkTea().getName());

			model.addAttribute("milktea", milkTeaModel);
			return new ModelAndView("user/product_detail", model);
		}
		
		model.addAttribute("message", "Milktea product is not existed!!!!");
		// chỗ này chưa biết trả về cái gì :)))
		return new ModelAndView("forward:/admin/categories", model);
	}
}
