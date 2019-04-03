package product.spring.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.spring.demo.entities.Product;
import product.spring.demo.repositories.ProductRepository;
import product.spring.demo.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductVO> getAllProducts() {
		List<Product> listEntities = productRepository.findAll();
		List<ProductVO> listVO = new ArrayList<>();
		for (Product element : listEntities) {
			ProductVO productVO = new ProductVO();
			productVO.setId(element.getIdProduct());
			productVO.setName(element.getName());
			listVO.add(productVO);
		}
		return listVO;
	}

	@Override
	public Product getById(String id) {
//		Product product = productRepository.findById(Integer.parseInt(id))
//										.orElse(new Product());
		
//		Optional<Product> optional = productRepository.findById(Integer.parseInt(id));
//		if (optional.isPresent()) {
//			return optional.get();
//		} else {
//			return null;
//		}
		return productRepository.getOne(Integer.parseInt(id));
	}

	@Override
	public List<ProductVO> findByName(String name) {
		List<Product> listEntities = productRepository.findByName(name);
		List<ProductVO> listVO = new ArrayList<>();
		for (Product element : listEntities) {
			ProductVO productVO = new ProductVO();
			productVO.setId(element.getIdProduct());
			productVO.setName(element.getName());
			listVO.add(productVO);
		}
		return listVO;
	}
}
