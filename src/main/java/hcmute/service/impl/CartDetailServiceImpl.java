package hcmute.service.impl;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hcmute.entity.CartDetailEntity;
import hcmute.repository.CartDetailRepository;
import hcmute.repository.CartRepository;
import hcmute.service.ICartDetailService;
@Service
public class CartDetailServiceImpl implements ICartDetailService{
=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.repository.CartDetailRepository;
import hcmute.service.ICartDetailService;

@Service
public class CartDetailServiceImpl implements ICartDetailService {
>>>>>>> 9a5e4c5a7ac1022044de3c099dba7bc65bdb9261
	@Autowired
	CartDetailRepository cartDetailRepository;

	public CartDetailServiceImpl(CartDetailRepository cartDetailRepository) {
<<<<<<< HEAD
		super();
		this.cartDetailRepository = cartDetailRepository;
	}

	@Override
	public <S extends CartDetailEntity> S save(S entity) {
		return cartDetailRepository.save(entity);
	}

	@Override
	public List<CartDetailEntity> findAll() {
		return cartDetailRepository.findAll();
	}

	@Override
	public Page<CartDetailEntity> findAll(Pageable pageable) {
		return cartDetailRepository.findAll(pageable);
	}

	@Override
	public List<CartDetailEntity> findAll(Sort sort) {
		return cartDetailRepository.findAll(sort);
	}

	@Override
	public List<CartDetailEntity> findAllById(Iterable<Integer> ids) {
		return cartDetailRepository.findAllById(ids);
	}

	@Override
	public Optional<CartDetailEntity> findById(Integer id) {
		return cartDetailRepository.findById(id);
	}

	@Override
	public long count() {
		return cartDetailRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		cartDetailRepository.deleteById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		cartDetailRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll() {
		cartDetailRepository.deleteAll();
	}
	
=======
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
>>>>>>> 9a5e4c5a7ac1022044de3c099dba7bc65bdb9261
}
