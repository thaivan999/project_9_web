package hcmute.embeddedId;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class CartDetailId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "idCart")
	private int idCart;
	
	@Column(name = "idMilkTea")
	private int idMilkTea;
	
	@Column(name = "size", columnDefinition = "nvarchar(50)")
	private String size;
	
}
