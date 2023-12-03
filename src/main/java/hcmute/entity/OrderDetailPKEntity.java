package hcmute.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailPKEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_order")
	private int idOrder;
	
	@Column(name = "id_milk_tea")
	private int idMilkTea;

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdMilkTea() {
		return idMilkTea;
	}

	public void setIdMilkTea(int idMilkTea) {
		this.idMilkTea = idMilkTea;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMilkTea, idOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailPKEntity other = (OrderDetailPKEntity) obj;
		return idMilkTea == other.idMilkTea && idOrder == other.idOrder;
	}

	public OrderDetailPKEntity(int idOrder, int idMilkTea) {
		super();
		this.idOrder = idOrder;
		this.idMilkTea = idMilkTea;
	}
	
}
