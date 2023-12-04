package hcmute.service;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import hcmute.entity.CartDetailEntity;

public interface ICartDetailService {

	void deleteAll();

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteById(Integer id);

	long count();

	Optional<CartDetailEntity> findById(Integer id);

	List<CartDetailEntity> findAllById(Iterable<Integer> ids);

	List<CartDetailEntity> findAll(Sort sort);

	Page<CartDetailEntity> findAll(Pageable pageable);

	List<CartDetailEntity> findAll();

	<S extends CartDetailEntity> S save(S entity);
=======
>>>>>>> 9a5e4c5a7ac1022044de3c099dba7bc65bdb9261

import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;

public interface ICartDetailService {

	List<MilkTeaEntity> findMilkTeaByCartId(int idCart);

	List<CartDetailEntity> findByCartByCartDetailIdCart(int idCart);
}
