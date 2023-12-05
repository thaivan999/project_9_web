package hcmute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchModel{
	private int idBranch;
	private String name;
	private String addressDetail;
	private String opentime;
	private String image;
	private String description;
	private String idCity;
	private Boolean isEdit = false;
}
