package hcmute.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;
	
	@Column(name = "surname",columnDefinition = "nvarchar(50)")
	private String surname;
	
	@Column(name = "name",columnDefinition = "nvarchar(50)")
	private String name;
	
	@Column(name = "birthday")
	private LocalDate birthday;
	
	@Column(name = "phone_number",columnDefinition = "varchar(50)")
	private String phoneNumber;
	
	@Column(name = "image_url", columnDefinition = "varchar(255)")
	private String image_url;
	
	@Column(name = "email",columnDefinition = "varchar(50)")
	private String email;
	
	@Column(name = "gender")
	private int gender;
	
	@OneToMany(mappedBy = "customerByCart")
	private Set<CartEntity> carts;
	
//	@OneToMany(mappedBy = "customerByUser")
//	private Set<UserEntity> accounts;
	
	@OneToMany(mappedBy = "customerByOrder")
	private Set<OrderEntity> orders;
	
	
}
