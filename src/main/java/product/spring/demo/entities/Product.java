package product.spring.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProduct;

	private String name;

	private float price;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Category category;

	//bi-directional one-to-one association to ProductDetail
	@OneToOne(mappedBy="product")
	private ProductDetail productDetail;

	//bi-directional many-to-many association to Order
	@ManyToMany
	@JoinTable(
		name="product_order"
		, joinColumns={
			@JoinColumn(name="idProduct")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idOrder")
			}
		)
	private List<Order> orders;

	public Product() {
	}

	public Integer getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ProductDetail getProductDetail() {
		return this.productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}