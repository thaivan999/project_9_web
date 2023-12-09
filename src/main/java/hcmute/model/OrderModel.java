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
	private int finalPrice;
	private LocalDateTime orderDay;
	private int orderState;
	private LocalDateTime shipDay;
	private String note;
	private String address;
	private String phoneNumber;
	private int fee;
	private PayMethodModel payMethodByOrder;
	private UserModel customerByOrder;
}
