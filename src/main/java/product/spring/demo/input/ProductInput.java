package product.spring.demo.input;

import lombok.Data;
import product.spring.demo.common.GenericInput;

@Data
public class ProductInput extends GenericInput {

	private static final long serialVersionUID = 1L;
	// for product
	private Integer idProduct;
	private String name;
	private float price;
	private Integer idCategory;
	// for detail
	private String content;
	private String description;

	@Override
	public boolean valid() {
		
		return false;
	}

}
