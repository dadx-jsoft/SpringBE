package product.spring.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_detail database table.
 * 
 */
@Entity
@Table(name="product_detail")
@NamedQuery(name="ProductDetail.findAll", query="SELECT p FROM ProductDetail p")
public class ProductDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;

	private String content;

	private String description;

	//bi-directional one-to-one association to Product
	@OneToOne
	@JoinColumn(name="idProduct")
	private Product product;

	public ProductDetail() {
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}