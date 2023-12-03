package hcmute.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserRole")
public class UserRoleEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_role",columnDefinition = "varchar(50)")
	private String idRole;
	
	@Column(name = "name",columnDefinition = "varchar(50)")
	private String name;
	
	@OneToMany(mappedBy = "userRoleByAccount")
	private Set<AccountEntity> accounts;
	
}
