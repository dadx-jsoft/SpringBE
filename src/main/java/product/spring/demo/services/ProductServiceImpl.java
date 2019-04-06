package product.spring.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.spring.demo.entities.Category;
import product.spring.demo.entities.Product;
import product.spring.demo.entities.ProductDetail;
import product.spring.demo.input.ProductInput;
import product.spring.demo.repositories.CategoryRepository;
import product.spring.demo.repositories.ProductRepository;
import product.spring.demo.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

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

	@Override
	public Integer createProduct(ProductInput productInput) {
		// Product
		Product product = new Product();
		product.setName(productInput.getName());
		product.setPrice(productInput.getPrice());

		// Category
		Category category = categoryRepository.getOne(productInput.getIdCategory());

		// ProductDetail
		ProductDetail productDetail = new ProductDetail();
		productDetail.setContent(productInput.getContent());
		productDetail.setDescription(productInput.getDescription());

		product.setCategory(category);
		product.setProductDetail(productDetail);

		productRepository.save(product);

		return product.getIdProduct();
	}

	@Override
	public Integer updateProduct(ProductInput productInput) {
		Product product = productRepository.findProductById(productInput.getIdProduct());
		// for productdetail
		ProductDetail productDetail = new ProductDetail();
		productDetail.setIdProduct(productInput.getIdProduct());
		productDetail.setContent(productInput.getContent());
		productDetail.setDescription(productInput.getDescription());
		// for product
		product.setName(productInput.getName());
		product.setPrice(productInput.getPrice());
		product.setCategory(categoryRepository.getOne(productInput.getIdCategory())); //set category for product
		product.setProductDetail(productDetail); 
		
		productRepository.save(product);
		return product.getIdProduct();
	}

	@Override
	public Integer deleteProduct(Integer idProduct) {
		productRepository.delete(productRepository.findProductById(idProduct));
		return 1;
	}
}
