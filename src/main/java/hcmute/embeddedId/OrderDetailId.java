package hcmute.embeddedId;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_order")
	private int idOrder;
	
	@Column(name = "id_milk_tea")
	private int idMilkTea;
	
	@Column(name = "size")
	private String size;
	
}
