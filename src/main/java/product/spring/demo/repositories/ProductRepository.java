package product.spring.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import product.spring.demo.entities.Category;
import product.spring.demo.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("Select p from Product p where p.name =:name")
	List<Product> findByName(@Param("name") String name);
	
//	List<Product> findByName(String name);
	@Query("Select p from Product p where p.id =:productId")
	Product findProductById(@Param("productId") Integer id);

}
