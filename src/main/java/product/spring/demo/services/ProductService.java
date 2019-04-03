package product.spring.demo.services;

import java.util.List;

import product.spring.demo.entities.Product;
import product.spring.demo.vo.ProductVO;

public interface ProductService {

	List<ProductVO> getAllProducts();
	Product getById(String id);
	List<ProductVO> findByName(String name);
}
