package hcmute.service;

import java.util.List;
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

}
