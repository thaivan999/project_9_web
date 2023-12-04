package hcmute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;

public interface ICartDetailService {

	List<MilkTeaEntity> findMilkTeaByCartId(int idCart);

	List<CartDetailEntity> findByCartByCartDetailIdCart(int idCart);

	void deleteAll();

	long count();

	List<CartDetailEntity> findAll(Sort sort);

	Page<CartDetailEntity> findAll(Pageable pageable);

	List<CartDetailEntity> findAll();

	<S extends CartDetailEntity> S save(S entity);

}
