package hcmute.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import hcmute.entity.AccountEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleModel{
	private String idRole;
	private String name;
	private AccountEntity accounts;
}
