package hcmute.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hcmute.model.AuthProvider;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;

    private String image_url;

    @Enumerated(EnumType.STRING) 
    private AuthProvider provider;
    private String provider_id;
    private Boolean enabled;
    private String verify_code;
    private String reset_pwd_token;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoleEntity> authorities;
    
    @ManyToOne
	@JoinColumn(name = "id_branch",insertable = false, updatable = false)
	private BranchEntity branchByUser;
    
    @ManyToOne
	@JoinColumn(name = "id_user",insertable = false, updatable = false)
	private CustomerEntity customerByUser;
}
