package hcmute.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkTeaTypeModel{
	private int idType;
	private String name;
	private MilkTeaCategoryModel milkTeaCategoryByMilkTeaType;
	private MilkTeaModel milkTeas;
	private Boolean isEdit = false;
	
}
