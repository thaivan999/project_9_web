package hcmute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import hcmute.entity.AccountEntity;

public interface IAccountService {

	void deleteAll();

	void delete(AccountEntity entity);

	void deleteById(Integer id);

	long count();

	Optional<AccountEntity> findById(Integer id);

	List<AccountEntity> findAllById(Iterable<Integer> ids);

	List<AccountEntity> findAll(Sort sort);

	Page<AccountEntity> findAll(Pageable pageable);

	List<AccountEntity> findAll();

	<S extends AccountEntity> S save(S entity);

}
