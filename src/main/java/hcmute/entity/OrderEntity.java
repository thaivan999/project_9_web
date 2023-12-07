
package hcmute.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "user_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private Integer idOrder;

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
	
	@Column(name = "note", columnDefinition = "nvarchar(1000)")
	private String note;
	
	@Column(name = "address", columnDefinition = "nvarchar(1000)")
	private String address;
	
	@Column(name = "phoneNumber",columnDefinition = "varchar(50)")
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "id_pay_method", insertable = false, updatable = false)
	private PayMethodEntity payMethodByOrder;

	@ManyToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	private CustomerEntity customerByOrder;

	@OneToMany(mappedBy = "orderByOrderDetail")
	private Set<OrderDetailEntity> orderDetails;

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public int getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public LocalDateTime getTentativeTime() {
		return tentativeTime;
	}

	public void setTentativeTime(LocalDateTime tentativeTime) {
		this.tentativeTime = tentativeTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PayMethodEntity getPayMethodByOrder() {
		return payMethodByOrder;
	}

	public void setPayMethodByOrder(PayMethodEntity payMethodByOrder) {
		this.payMethodByOrder = payMethodByOrder;
	}

	public CustomerEntity getCustomerByOrder() {
		return customerByOrder;
	}

	public void setCustomerByOrder(CustomerEntity customerByOrder) {
		this.customerByOrder = customerByOrder;
	}

	public Set<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderEntity(Integer idOrder, int totalProduct, int totalPrice, LocalDateTime orderTime, int orderState,
			LocalDateTime tentativeTime, String note, String address, String phoneNumber,
			PayMethodEntity payMethodByOrder, CustomerEntity customerByOrder, Set<OrderDetailEntity> orderDetails) {
		super();
		this.idOrder = idOrder;
		this.totalProduct = totalProduct;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.orderState = orderState;
		this.tentativeTime = tentativeTime;
		this.note = note;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.payMethodByOrder = payMethodByOrder;
		this.customerByOrder = customerByOrder;
		this.orderDetails = orderDetails;
	}

	public OrderEntity() {
		super();
	}
	
}
