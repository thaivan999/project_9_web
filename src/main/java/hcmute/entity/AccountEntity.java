package hcmute.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Account")
public class AccountEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account")
	private int idAccount;
	
	@Column(name = "username",columnDefinition = "varchar(50)")
	private String username;
	
	@Column(name = "password",columnDefinition = "varchar(50)")
	private String password;
	
	@Column(name = "create_at")
	private LocalDateTime createAt;
	
	@ManyToOne
	@JoinColumn(name = "id_branch",insertable = false, updatable = false)
	private BranchEntity branchByAccount;
	
	@ManyToOne
	@JoinColumn(name = "id_role",insertable = false, updatable = false)
	private UserRoleEntity userRoleByAccount;
	
	@ManyToOne
	@JoinColumn(name = "id_user",insertable = false, updatable = false)
	private CustomerEntity customerByAccount;
}
