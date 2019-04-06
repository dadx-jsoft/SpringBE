package product.spring.demo.services;

import java.util.List;

import product.spring.demo.entities.Category;
import product.spring.demo.input.CategoryInput;

public interface CategoryService {
	
	List<Category> getAllCategories();
	Category getById(String id);
	List<Category> getByName(String name);
	Integer createCategory(String name);
	Integer updateCategory(CategoryInput categoryInput);
	boolean deleteCategory(Integer idCategory);
}
