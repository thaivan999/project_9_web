package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import hcmute.embeddedId.CartDetailId;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CartDetail")
public class CartDetailEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private CartDetailId idCartDetail;
	
	@Column(name = "size", columnDefinition = "nvarchar(50)")
	private String size;

	@ManyToOne
	@JoinColumn(name = "id_cart",insertable = false, updatable = false)
	private CartEntity cartByCartDetail;
	
	@ManyToOne
	@JoinColumn(name = "id_milk_tea",insertable = false, updatable = false)
	private MilkTeaEntity milkTeaByCartDetail;
}
