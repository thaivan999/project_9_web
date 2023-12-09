//package hcmute.controller.admin;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
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
//import hcmute.entity.MilkTeaEntity;
//import hcmute.model.MilkTeaModel;
//import hcmute.service.IMilkTeaService;
//import hcmute.service.IStorageService;
//
//@Controller
//@RequestMapping("admin")
//public class MilkTeaAdminController {
//
//	@Autowired
//	private IMilkTeaService milkTeaService;
//
//	@Autowired
//	private IStorageService storageService;
//
//	@GetMapping("view-milk-tea")
//	public String IndexViewMilkTea(ModelMap model) {
//		List<MilkTeaEntity> milkTeas = milkTeaService.findAll();
//		model.addAttribute("milkTeas", milkTeas);
//		return "admin/view/view-milk-tea";
//	}
//
//	@GetMapping("customize-milk-tea")
//	public String IndexCustomizeMilkTea() {
//		return "admin/customize/customize-milk-tea";
//	}
//
//	@GetMapping("customize-milk-tea/add")
//	public String add(ModelMap model) {
//		MilkTeaModel milkTea = new MilkTeaModel();
//		milkTea.setIsEdit(false);
//		model.addAttribute("milkTea", milkTea);
//		return "admin/customize/customize-milk-tea";
//	}
//
//	@PostMapping("customize-milk-tea/saveOrUpdate")
//	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("milkTea") MilkTeaModel milkTea,
//			BindingResult result) {
//		if (result.hasErrors()) {
//			return new ModelAndView("admin/customize/customize-milk-tea");
//		}
//		if (milkTea != null) {
//			MilkTeaEntity entity = new MilkTeaEntity();
//			if (milkTea.getIdMilkTea() != 0) {
//				entity.setIdMilkTea(milkTea.getIdMilkTea());
//			}
//			if (milkTea.getName() != null) {
//				entity.setName(milkTea.getName());
//			}
//			if (milkTea.getCost() != 0) {
//				entity.setCost(milkTea.getCost());
//			}
//			if (milkTea.getDescription() != null) {
//				entity.setDescription(milkTea.getDescription());
//			}
//			if (milkTea.getRemainQuantity() != 0) {
//				entity.setRemainQuantity(milkTea.getRemainQuantity());
//			}
//			if (milkTea.getImage() != null) {
//				entity.setImage(milkTea.getImage());
//			}
//
//			if (milkTea.getImageFile() != null && !milkTea.getImageFile().isEmpty()) {
//				UUID uuid = UUID.randomUUID();
//				String uuString = uuid.toString();
//				entity.setImage(storageService.getStorageFilename(milkTea.getImageFile(), uuString));
//				storageService.store(milkTea.getImageFile(), entity.getImage());
//			} else {
//				model.addAttribute("message", "Không thể lưu milkTea với dữ liệu null");
//			}
//			milkTeaService.save(entity);
//			String message = milkTea.getIsEdit() ? "milkTea đã được cập nhật thành công"
//					: "milkTea đã được thêm thành công";
//			model.addAttribute("message", message);
//		} else {
//			model.addAttribute("message", "Không thể lưu milkTea với dữ liệu null");
//		}
//
//		/*
//		 * MilkTeaEntity entity = new MilkTeaEntity(); BeanUtils.copyProperties(milkTea,
//		 * entity); milkTeaService.save(entity); String message = ""; if
//		 * (milkTea.getIsEdit() == true) { message =
//		 * "milkTea đã được cập nhật thành công"; } else { message =
//		 * "milkTea đã được thêm thành công"; } model.addAttribute("message", message);
//		 */
//		return new ModelAndView("redirect:/admin/view-milk-tea", model);
//	}
//
//	@GetMapping("/images/{filename:.+}")
//	public ResponseEntity<Resource> serverFile(@PathVariable String filename) {
//		Resource file = storageService.loadAsResource(filename);
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFilename() + "\"")
//				.body(file);
//	}
//
//	@GetMapping("customize-milk-tea/saveOrUpdate/{idMilkTea}")
//	public ModelAndView edit(ModelMap model, @PathVariable("idMilkTea") int idMilkTea) {
//		Optional<MilkTeaEntity> opt = milkTeaService.findByIdMilkTea(idMilkTea);
//		MilkTeaModel milkTea = new MilkTeaModel();
//		if (opt.isPresent()) {
//			MilkTeaEntity entity = opt.get();
//			BeanUtils.copyProperties(entity, milkTea);
//			milkTea.setIsEdit(true);
//			model.addAttribute("milkTea", milkTea);
//			return new ModelAndView("admin/customize/customize-milk-tea", model);
//		}
//		model.addAttribute("message", "milkTea không tồn tại");
//		return new ModelAndView("forward:/admin/view-milk-tea", model);
//	}
//}
