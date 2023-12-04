package hcmute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import hcmute.entity.BranchEntity;

public interface IBranchService {

	void deleteAll();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(BranchEntity entity);

	void deleteById(Integer id);

	long count();

	List<BranchEntity> findAllById(Iterable<Integer> ids);

	List<BranchEntity> findAll(Sort sort);

	Page<BranchEntity> findAll(Pageable pageable);

	List<BranchEntity> findAll();

	<S extends BranchEntity> S save(S entity);

	Optional<BranchEntity> findById(Integer id);

}
