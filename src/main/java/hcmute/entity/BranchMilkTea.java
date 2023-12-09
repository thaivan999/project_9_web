package hcmute.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hcmute.embeddedId.BranchMilkTeaId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branch_milk_tea")
public class BranchMilkTea implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BranchMilkTeaId branchMilkTeaId;
	
	@Column(name = "remain_quantity")
	private int remainQuantity;
	
	@ManyToOne
	@JoinColumn(name = "id_branch",insertable = false, updatable = false)
	private BranchEntity branchByBranchMilkTea;
	
	@ManyToOne
	@JoinColumn(name = "id_milk_tea",insertable = false, updatable = false)
	private MilkTeaEntity milkTeaByBranchMilkTea;
}
