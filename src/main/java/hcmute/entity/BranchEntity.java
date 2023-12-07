package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.*;


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

	public int getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(int idBranch) {
		this.idBranch = idBranch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdCity() {
		return idCity;
	}

	public void setIdCity(String idCity) {
		this.idCity = idCity;
	}

	public CityEntity getCityByBranch() {
		return cityByBranch;
	}

	public void setCityByBranch(CityEntity cityByBranch) {
		this.cityByBranch = cityByBranch;
	}

	public Set<MilkTeaEntity> getMilkTeas() {
		return milkTeas;
	}

	public void setMilkTeas(Set<MilkTeaEntity> milkTeas) {
		this.milkTeas = milkTeas;
	}

	public BranchEntity(int idBranch, String name, String addressDetail, String opentime, String image,
			String description, CityEntity cityByBranch, Set<MilkTeaEntity> milkTeas) {
		super();
		this.idBranch = idBranch;
		this.name = name;
		this.addressDetail = addressDetail;
		this.opentime = opentime;
		this.image = image;
		this.description = description;
		this.idCity = idCity;
		this.cityByBranch = cityByBranch;
		this.milkTeas = milkTeas;
	}

	public BranchEntity() {
		super();
	}
	
	
}
