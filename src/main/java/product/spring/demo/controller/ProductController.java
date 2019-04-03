package product.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product.spring.demo.input.ProductSearch;
import product.spring.demo.services.ProductService;
import product.spring.demo.vo.ProductVO;

@Controller // Để spring có thể scan được
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProductVO> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping(value = "/products/search", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProductVO> getProductByName(@RequestBody ProductSearch productSearch) {
		return (List<ProductVO>) productService.findByName(productSearch.getName());
	}
}
