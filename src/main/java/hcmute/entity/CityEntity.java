package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "City")
public class CityEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idCity", columnDefinition = "varchar(100)")
	private String idCity;
	
	@Column(name = "name", columnDefinition = "nvarchar(50)")
	private String name;
	
	@OneToMany(mappedBy = "cityByBranch")
	private Set<BranchEntity> branches;
}
