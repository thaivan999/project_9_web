package hcmute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.repository.CartDetailRepository;
import hcmute.service.ICartDetailService;

@Service
public class CartDetailServiceImpl implements ICartDetailService {
	@Autowired
	CartDetailRepository cartDetailRepository;

	public CartDetailServiceImpl(CartDetailRepository cartDetailRepository) {
		this.cartDetailRepository = cartDetailRepository;
	}
	
	@Override
	public List<CartDetailEntity> findByCartByCartDetailIdCart(int idCart) {
		return cartDetailRepository.findByCartByCartDetailIdCart(idCart);
	}

    @Override
	public List<MilkTeaEntity> findMilkTeaByCartId(int idCart) {
    	return cartDetailRepository.findMilkTeaByCartId(idCart);
    }

	@Override
	public void addProductToCart(int idCart, int idMilkTea, String size) {
		cartDetailRepository.addProductToCart(idCart, idMilkTea, size);		
	}
}
