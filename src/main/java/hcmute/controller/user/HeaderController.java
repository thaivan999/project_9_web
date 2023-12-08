package hcmute.controller.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.MilkTeaTypeEntity;
import hcmute.service.IMilkTeaCategoryService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IMilkTeaTypeService;

@Controller
@RequestMapping("header")
public class HeaderController {
	@Autowired
	IMilkTeaCategoryService milkTeaCategoryService;
	@Autowired
	IMilkTeaTypeService milkTeaTypeService;
	@Autowired
	IMilkTeaService milkTeaService;


	@GetMapping("/search")
	public String showCategory(Model model, @RequestParam("page") Optional<Integer> page) {
		int count = (int) milkTeaService.count();
		int currentPage = page.orElse(1);
		int pageSize = 8;

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("idMilkTea"));
		Page<MilkTeaEntity> resultpaPage = null;
		resultpaPage = milkTeaService.findAll(pageable);

		int totalPages = resultpaPage.getTotalPages();
		if (totalPages > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPages);
			if (totalPages > count) {
				if (end == totalPages)
					start = end - count;
				else if (start == 1)
					end = start + count;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);

		}
		model.addAttribute("milkTeas", resultpaPage);
		return "user/search";
	}

	@RequestMapping("search/content={name}")
	public String getMilkTeaByNameContaining(@PathVariable("name") String encodedName, Model model, @RequestParam("page") Optional<Integer> page) {
		int count = milkTeaService.countByNameContaining(encodedName);
		int currentPage = page.orElse(1);
		int pageSize = 8;

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("idMilkTea"));
		Page<MilkTeaEntity> resultpaPage = null;
		resultpaPage = milkTeaService.findByNameContaining(encodedName, pageable);
		int totalPages = resultpaPage.getTotalPages();
		if (totalPages > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPages);
			if (totalPages > count) {
				if (end == totalPages)
					start = end - count;
				else if (start == 1)
					end = start + count;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		model.addAttribute("milkTeasByNames", resultpaPage);
		String name;
		try {
			name = URLDecoder.decode(encodedName, StandardCharsets.UTF_8.toString());
			model.addAttribute("content", name);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "user/search";
	}

//	private List<MilkTeaEntity> milkTeas;
//	@RequestMapping("search/content={name}/method={method}")
//	public String searchAndSort(@PathVariable("name") String encodedName, @PathVariable("method") String method,
//			Model model) {
//		try {
//			String name = URLDecoder.decode(encodedName, StandardCharsets.UTF_8.toString());
//			model.addAttribute("content", name);
//
//			if ("outstanding".equals(method)) {
//				milkTeas = milkTeaService.findByNameContaining(name);
//				System.out.println("outstanding method");
//				milkTeaService.sortByOrderDetailQuantity(milkTeas);
//
//			} else if ("low-to-high".equals(method)) {
//				milkTeas = milkTeaService.findByNameContainingAndSortAscendingByCost(name);
//				System.out.println("low-to-high");
//			} else if ("high-to-low".equals(method)) {
//				milkTeas = milkTeaService.findByNameContainingAndSortDescendingByCost(name);
//				System.out.println("high-to-low");
//			}
//
//			
//			model.addAttribute("milkTeas", milkTeas);
//			return "user/search";
//
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//			return "error";
//		}
//	}

	@GetMapping("/moveToSearchPage")
	public RedirectView moveToSearchPage(RedirectAttributes redirectAttributes,
			@RequestParam("content") String content) {
		try {
			String encodedContent = URLEncoder.encode(content, StandardCharsets.UTF_8.toString());
			return new RedirectView("/header/search/content=" + encodedContent);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new RedirectView("/error");
		}
	}

}
