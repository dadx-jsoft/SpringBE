package product.spring.demo.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import product.spring.demo.vo.ProductVO;

@Controller
public class ProductPageController {

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView productPage() {
		ModelAndView m = new ModelAndView("productListPage");

		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO productVO = new ProductVO();
		productVO.setId(1);
		productVO.setName("Product 1");
		productVO.setImage("/images/item.png");
		products.add(productVO);

		m.addObject("productList", products);
		return m;
	}

}
