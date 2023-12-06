package hcmute.embeddedId;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import hcmute.model.OrderData;
import hcmute.model.OrderData.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_order")
	private int idOrder;
	
	@Column(name = "id_milk_tea")
	private int idMilkTea;
	
	@Column(name = "size")
	private String size;
	
}
