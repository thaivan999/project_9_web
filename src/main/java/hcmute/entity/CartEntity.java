package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "cart")
public class CartEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cart")
	private int idCart;
	
	@Column(name = "total_product")
	private int totalProduct;
	
	@Column(name = "total_price")
	private int totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "id_user",insertable = false, updatable = false)
	private CustomerEntity customerByCart;
	
	@OneToMany(mappedBy = "cartByCartDetail")
	private Set<CartDetailEntity> cartDetails;

	public CartEntity(int idCart, int totalProduct, int totalPrice, CustomerEntity customerByCart,
			Set<CartDetailEntity> cartDetails) {
		super();
		this.idCart = idCart;
		this.totalProduct = totalProduct;
		this.totalPrice = totalPrice;
		this.customerByCart = customerByCart;
		this.cartDetails = cartDetails;
	}

	public CartEntity() {
		super();
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public int getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CustomerEntity getCustomerByCart() {
		return customerByCart;
	}

	public void setCustomerByCart(CustomerEntity customerByCart) {
		this.customerByCart = customerByCart;
	}

	public Set<CartDetailEntity> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(Set<CartDetailEntity> cartDetails) {
		this.cartDetails = cartDetails;
	}
	
}
