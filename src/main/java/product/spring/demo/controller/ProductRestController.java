package product.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import product.spring.demo.input.ProductInput;
import product.spring.demo.input.ProductSearch;
import product.spring.demo.services.ProductService;
import product.spring.demo.vo.ProductVO;

@RestController // Để spring có thể scan được
@RequestMapping("/rest")
public class ProductRestController {

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
	
	@RequestMapping(value = "/products/create", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Integer createProduct(@RequestBody ProductInput productInput) {
		return productService.createProduct(productInput);
	}
	
	@RequestMapping(value = "/products/update", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Integer updateProduct(@RequestBody ProductInput productInput) {
		return productService.updateProduct(productInput);
	}
	
	@RequestMapping(value = "/products/delete", method = RequestMethod.DELETE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Integer updateProduct(@RequestBody Integer idProduct) {
		return productService.deleteProduct(idProduct);
	}
	
}
