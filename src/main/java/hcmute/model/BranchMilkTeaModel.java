package hcmute.model;
import hcmute.embeddedId.BranchMilkTeaId;
import hcmute.entity.BranchEntity;
import hcmute.entity.MilkTeaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchMilkTeaModel {
	private BranchMilkTeaId branchMilkTeaId;
	private BranchEntity branchByBranchMilkTea;
	private MilkTeaEntity milkTeaByBranchMilkTea;
	private int remainQuantity;
}
