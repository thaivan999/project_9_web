package hcmute.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel{
	private int idOrder;
	private int totalProduct;
	private int totalPrice;
	private LocalDateTime orderTime;
	private LocalDateTime tentativeTime;
	private int orderState;
	private String note;
	private String address;
	private String phoneNumber;
	private PayMethodModel payMethodByOrder;
	private CustomerModel customerByOrder;
}
