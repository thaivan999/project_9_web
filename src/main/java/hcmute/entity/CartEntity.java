package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cart")
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
}
