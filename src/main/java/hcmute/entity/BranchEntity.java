package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branch")
public class BranchEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_branch")
	private int idBranch;
	
	@Column(name = "name", columnDefinition = "nvarchar(1000)")
	private String name;
	
	@Column(name = "address_detail",columnDefinition = "nvarchar(1000)")
	private String addressDetail;
	
	@Column(name = "opentime",columnDefinition = "varchar(50)")
	private String opentime;
	
	@Column(name = "image",columnDefinition = "varchar(1000)")
	private String image;
	
	@Column(name = "description",columnDefinition = "nvarchar(1000)")
	private String description;
	
	@Column(name = "id_city",columnDefinition = "varchar(100)")
	private String idCity;
	
	@ManyToOne
	@JoinColumn(name = "id_city",insertable = false, updatable = false)
	private CityEntity cityByBranch;
	
	@OneToMany(mappedBy = "branchByUser")
	private Set<UserEntity> accounts;
		
	@OneToMany(mappedBy = "branchByMilkTea")
	private Set<MilkTeaEntity> milkTeas;
}
