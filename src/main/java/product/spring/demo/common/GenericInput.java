package product.spring.demo.common;

import java.io.Serializable;

public abstract class GenericInput implements Serializable {
	private static final long serialVersionUID = 1L;

	public abstract boolean valid();
}
