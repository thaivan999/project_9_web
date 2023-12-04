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
	@Column(name = "idCart")
	private int idCart;
	
	@Column(name = "totalProduct")
	private int totalProduct;
	
	@Column(name = "totalPrice")
	private int totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "idUser",insertable = false, updatable = false)
	private CustomerEntity customerByCart;
	
	@OneToMany(mappedBy = "cartByCartDetail")
	private Set<CartDetailEntity> cartDetails;
}
