package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Branch")
public class BranchEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBranch")
	private int idBranch;
	
	@Column(name = "name", columnDefinition = "nvarchar(1000)")
	private String name;
	
	@Column(name = "addressDetail",columnDefinition = "nvarchar(1000)")
	private String addressDetail;
	
	@Column(name = "opentime",columnDefinition = "varchar(50)")
	private String opentime;
	
	@Column(name = "image",columnDefinition = "varchar(1000)")
	private String image;
	
	@Column(name = "description",columnDefinition = "nvarchar(1000)")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "idCity",insertable = false, updatable = false)
	private CityEntity cityByBranch;
	
	@OneToMany(mappedBy = "branchByAccount")
	private Set<AccountEntity> accounts;
		
	@OneToMany(mappedBy = "branchByMilkTea")
	private Set<MilkTeaEntity> milkTeas;
	
}
