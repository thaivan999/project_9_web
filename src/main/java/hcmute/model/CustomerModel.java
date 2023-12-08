package hcmute.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel{
	private int idUser;
	private String surname;
	private String name;
	private LocalDate birthday;
	private String phoneNumber;
	private String email;
	private int gender;
	private OrderModel orders;
	private Boolean isEdit=false;
}
