package hcmute.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CartDetailPKEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "idCart")
	private int idCart;
	
	@Column(name = "idMilkTea")
	private int idMilkTea;

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public int getIdMilkTea() {
		return idMilkTea;
	}

	public void setIdMilkTea(int idMilkTea) {
		this.idMilkTea = idMilkTea;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCart, idMilkTea);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDetailPKEntity other = (CartDetailPKEntity) obj;
		return idCart == other.idCart && idMilkTea == other.idMilkTea;
	}

	public CartDetailPKEntity() {
		super();
	}

	public CartDetailPKEntity(int idCart, int idMilkTea) {
		super();
		this.idCart = idCart;
		this.idMilkTea = idMilkTea;
	}
	
	
}
