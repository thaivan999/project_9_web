package hcmute.model;

import hcmute.entity.MilkTeaEntity;
import hcmute.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel{
	private int quantity;
	private int size;
	private String note;
	private OrderEntity orderByOrderDetail;
	private MilkTeaEntity milkTeaByOrderDetail;
}
