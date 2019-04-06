package product.spring.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.spring.demo.entities.Category;
import product.spring.demo.input.CategoryInput;
import product.spring.demo.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		List<Category> list =  categoryRepository.findAll();
		return list;
	}

	@Override
	public Category getById(String id) {
		return categoryRepository.getOne(Integer.parseInt(id));
	}

	@Override
	public List<Category> getByName(String name) {
		List<Category> listCategory = categoryRepository.findByName(name);
		return listCategory;
	}

	@Override
	public Integer createCategory(String name) {
		Category category = new Category();
		category.setName(name);
		categoryRepository.save(category);
		return category.getIdCategory();
	}

	@Override
	public Integer updateCategory(CategoryInput categoryInput) {
		Optional<Category> optional = categoryRepository.findById(categoryInput.getIdCategory());
		Category category = null;
		if (optional.isPresent()) {
			category = optional.get();
			category.setName(categoryInput.getNameCategory());
			categoryRepository.save(category);
		}
		return category.getIdCategory();
	}

	@Override
	public boolean deleteCategory(Integer idCategory) {
		Category category = categoryRepository.getOne(idCategory); 
		if(category != null) {
			categoryRepository.delete(category);
			return true;
		}
		return false;
	}

}

