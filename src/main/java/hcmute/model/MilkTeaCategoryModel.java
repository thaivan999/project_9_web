package hcmute.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkTeaCategoryModel{
	private int idCategory;
	private String name;	
	private Set<MilkTeaTypeModel> milkTeaTypes;
}
