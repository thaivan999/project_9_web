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
@Table(name = "user_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private int idOrder;

	@Column(name = "total_product")
	private int totalProduct;

	@Column(name = "total_price")
	private int totalPrice;

	@Column(name = "order_time")
	private LocalDateTime orderTime;

	@Column(name = "order_state")
	private int orderState;

	@Column(name = "tentative_time")
	private LocalDateTime tentativeTime;

	@ManyToOne
	@JoinColumn(name = "id_pay_method", insertable = false, updatable = false)
	private PayMethodEntity payMethodByOrder;

	@ManyToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	private CustomerEntity customerByOrder;

	@OneToMany(mappedBy = "orderByOrderDetail")
	private Set<OrderDetailEntity> orderDetails;
}
