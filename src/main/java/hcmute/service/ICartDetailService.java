package hcmute.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;

public interface ICartDetailService {

	List<MilkTeaEntity> findMilkTeaByCartId(int idCart);

	List<CartDetailEntity> findByCartByCartDetailIdCart(int idCart);
	
	void addProductToCart(@Param("idCart") int idCart, @Param("idMilkTea") int idMilkTea, @Param("size") String size);
}
