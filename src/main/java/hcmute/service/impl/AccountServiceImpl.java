package hcmute.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import hcmute.entity.AccountEntity;
import hcmute.repository.AccountRepository;
import hcmute.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public <S extends AccountEntity> S save(S entity) {
		return accountRepository.save(entity);
	}

	@Override
	public List<AccountEntity> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Page<AccountEntity> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@Override
	public List<AccountEntity> findAll(Sort sort) {
		return accountRepository.findAll(sort);
	}

	@Override
	public List<AccountEntity> findAllById(Iterable<Integer> ids) {
		return accountRepository.findAllById(ids);
	}

	@Override
	public Optional<AccountEntity> findById(Integer id) {
		return accountRepository.findById(id);
	}

	@Override
	public long count() {
		return accountRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void delete(AccountEntity entity) {
		accountRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		accountRepository.deleteAll();
	}
	
}
