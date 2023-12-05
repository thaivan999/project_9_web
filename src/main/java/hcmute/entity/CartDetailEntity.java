package hcmute.entity;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;
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
	private CartDetailId id;
	
	@Column(name = "size",columnDefinition = "nvarchar(100)")
	private String size;
	
	@ManyToOne
	@JoinColumn(name = "idCart",insertable = false, updatable = false)
	private CartEntity cartByCartDetail;
	
	@ManyToOne
	@JoinColumn(name = "idMilkTea",insertable = false, updatable = false)
	private MilkTeaEntity milkTeaByCartDetail;
}
