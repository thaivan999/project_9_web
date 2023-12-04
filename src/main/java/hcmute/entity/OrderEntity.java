package hcmute.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserOrder")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOrder")
	private int idOrder;

	@Column(name = "totalProduct")
	private int totalProduct;

	@Column(name = "totalPrice")
	private int totalPrice;

	@Column(name = "orderTime")
	private LocalDateTime orderTime;

	@Column(name = "orderState")
	private int orderState;

	@Column(name = "tentativeTime")
	private LocalDateTime tentativeTime;

	@ManyToOne
	@JoinColumn(name = "idPayMethod", insertable = false, updatable = false)
	private PayMethodEntity payMethodByOrder;

	@ManyToOne
	@JoinColumn(name = "idUser", insertable = false, updatable = false)
	private CustomerEntity customerByOrder;

	@OneToMany(mappedBy = "orderByOrderDetail")
	private Set<OrderDetailEntity> orderDetails;
}
