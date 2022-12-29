package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.service.CategoryService;
import com.green.nowon.service.impl.CategoryServiceProcess;

@Controller
public class CategoryController {

	@Autowired
	CategoryService service;
	
	@GetMapping("/category/add")
	public String reg() {
		return "/admin/category/add";
	}
	
	@PostMapping("/category/add")
	public String add(String[] name) {
		service.add(name);
		return "/category/add";
	}
	
	@GetMapping("/common/layout/categorys/{parentNo}")
	public String category(@PathVariable long parentNo, Model model) {
		service.categoryList(parentNo, model);
		return "category/ol-category";
	}
}
