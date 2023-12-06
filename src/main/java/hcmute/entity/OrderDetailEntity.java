package hcmute.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hcmute.embeddedId.OrderDetailId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderDetail")
public class OrderDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailId idOrderDetail;

	@Column(name = "quantity")
	private int quantity;
	
//	@Column(name = "note", columnDefinition = "nvarchar(1000)")
//	private String note;

	@ManyToOne
	@JoinColumn(name = "idOrder", insertable = false, updatable = false)
	private OrderEntity orderByOrderDetail;

	@ManyToOne
	@JoinColumn(name = "idMilkTea", insertable = false, updatable = false)
	private MilkTeaEntity milkTeaByOrderDetail;
}
