package hcmute.model;

import java.time.LocalDateTime;

import hcmute.entity.BranchEntity;
import hcmute.entity.CustomerEntity;
import hcmute.entity.UserRoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	private int idAccount;
	private String username;
	private String password;
	private LocalDateTime createAt;
	private BranchEntity branchByAccount;
	private UserRoleEntity userRoleByAccount;
	private CustomerEntity customerByAccount;
	private Boolean isEdit = false;
}
