package product.spring.demo.input;

import java.io.Serializable;

public class ProductSearch implements Serializable {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
