package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;



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

	public String getIdCity() {
		return idCity;
	}

	public void setIdCity(String idCity) {
		this.idCity = idCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BranchEntity> getBranches() {
		return branches;
	}

	public void setBranches(Set<BranchEntity> branches) {
		this.branches = branches;
	}

	public CityEntity(String idCity, String name, Set<BranchEntity> branches) {
		super();
		this.idCity = idCity;
		this.name = name;
		this.branches = branches;
	}

	public CityEntity() {
		super();
	}
	
}
