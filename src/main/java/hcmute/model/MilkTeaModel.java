package hcmute.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkTeaModel{
	private int idMilkTea;
	private String name;
	private int cost;
	private String description;
	private int remainQuantity;
	private int orderQuantity;
	private String image;
	
	// use for product detail
	private String milkTeaType;
	private String size;
	private int milkTeaTypeId;
	
	private MilkTeaTypeModel milkTeaTypeByMilkTea;
	private BranchModel branchByMilkTea;
	private CartDetailModel cartDetails;
	
	private Boolean isEdit = false;
	private MultipartFile imageFile;
	
}
