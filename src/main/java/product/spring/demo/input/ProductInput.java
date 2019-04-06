package product.spring.demo.input;

import lombok.Data;

@Data
public class ProductInput {
	//for product
	private Integer idProduct;
	private String name;
	private float price;
	private Integer idCategory;
	//for detail 
	private String content;
	private String description;
	
}
