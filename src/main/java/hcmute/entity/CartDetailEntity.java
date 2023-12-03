package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CartDetail")
public class CartDetailEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_cart")
	private int idCart;
	
	@Column(name = "id_milk_tea")
	private int idMilkTea;

	@ManyToOne
	@JoinColumn(name = "id_cart",insertable = false, updatable = false)
	private CartEntity cartByCartDetail;
	
	@ManyToOne
	@JoinColumn(name = "id_milk_tea",insertable = false, updatable = false)
	private MilkTeaEntity milkTeaByCartDetail;
}
