package product.spring.demo.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@RequestMapping(value = "hello")
	private String helloSpringMVC() {
		return "hello";
	}
}
