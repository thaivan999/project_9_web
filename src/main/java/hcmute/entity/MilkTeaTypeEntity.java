package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	
	
}
