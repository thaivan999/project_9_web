package hcmute.model;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailModel{
	private String size;
	private CartModel cartByCartDetail;
	private MilkTeaModel milkTeaByCartDetail;
	private Boolean isEdit = false;
}
