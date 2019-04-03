package product.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product.spring.demo.entities.Category;
import product.spring.demo.services.CategoryService;


@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/categories", method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Category> getAllCategories() {
		List<Category> list =  categoryService.getAllCategories();
		return list;
	}
}
