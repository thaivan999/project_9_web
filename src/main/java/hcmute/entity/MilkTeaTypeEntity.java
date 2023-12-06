package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "milk_tea_type")
public class MilkTeaTypeEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type")
	private int idType;
	
	@Column(name = "name",columnDefinition = "nvarchar(100)")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_category",insertable = false, updatable = false)
	private MilkTeaCategoryEntity milkTeaCategoryByMilkTeaType;
	
	@OneToMany(mappedBy = "milkTeaTypeByMilkTea")
	private Set<MilkTeaEntity> milkTeas;

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MilkTeaCategoryEntity getMilkTeaCategoryByMilkTeaType() {
		return milkTeaCategoryByMilkTeaType;
	}

	public void setMilkTeaCategoryByMilkTeaType(MilkTeaCategoryEntity milkTeaCategoryByMilkTeaType) {
		this.milkTeaCategoryByMilkTeaType = milkTeaCategoryByMilkTeaType;
	}

	public Set<MilkTeaEntity> getMilkTeas() {
		return milkTeas;
	}

	public void setMilkTeas(Set<MilkTeaEntity> milkTeas) {
		this.milkTeas = milkTeas;
	}

	public MilkTeaTypeEntity(int idType, String name, MilkTeaCategoryEntity milkTeaCategoryByMilkTeaType,
			Set<MilkTeaEntity> milkTeas) {
		super();
		this.idType = idType;
		this.name = name;
		this.milkTeaCategoryByMilkTeaType = milkTeaCategoryByMilkTeaType;
		this.milkTeas = milkTeas;
	}

	public MilkTeaTypeEntity() {
		super();
	}
	
}
