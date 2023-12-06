package hcmute.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hcmute.entity.BranchEntity;
import hcmute.repository.BranchRepository;
import hcmute.service.IBranchService;
@Service
public class BranchServiceImpl implements IBranchService{
	@Autowired
	BranchRepository branchRepository;

	public BranchServiceImpl(BranchRepository branchRepository) {
		super();
		this.branchRepository = branchRepository;
	}

	@Override
	public <S extends BranchEntity> S save(S entity) {
		return branchRepository.save(entity);
	}

	@Override
	public List<BranchEntity> findAll() {
		return branchRepository.findAll();
	}

	@Override
	public Page<BranchEntity> findAll(Pageable pageable) {
		return branchRepository.findAll(pageable);
	}

	@Override
	public List<BranchEntity> findAll(Sort sort) {
		return branchRepository.findAll(sort);
	}

	@Override
	public List<BranchEntity> findAllById(Iterable<Integer> ids) {
		return branchRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return branchRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		branchRepository.deleteById(id);
	}

	@Override
	public void delete(BranchEntity entity) {
		branchRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		branchRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll() {
		branchRepository.deleteAll();
	}

	@Override
	public Optional<BranchEntity> findById(Integer id) {
		return branchRepository.findById(id);
	}

	@Override
	public BranchEntity getById(Integer id) {
		return branchRepository.getById(id);
	}

	

	
	
}
