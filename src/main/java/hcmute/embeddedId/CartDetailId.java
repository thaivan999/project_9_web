package hcmute.embeddedId;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartDetailId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_cart")
	private int idCart;
	
	@Column(name = "id_milk_tea")
	private int idMilkTea;
	
}
