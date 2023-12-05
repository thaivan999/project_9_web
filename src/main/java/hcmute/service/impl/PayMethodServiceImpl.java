package hcmute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.entity.PayMethodEntity;
import hcmute.repository.PayMethodRepository;
import hcmute.service.IPayMethodService;

@Service
public class PayMethodServiceImpl implements IPayMethodService{
	@Autowired
	PayMethodRepository payMethodRepository;

	public PayMethodServiceImpl(PayMethodRepository payMethodRepository) {
		super();
		this.payMethodRepository = payMethodRepository;
	}

	@Override
	public List<PayMethodEntity> findAll() {
		return payMethodRepository.findAll();
	}

}
