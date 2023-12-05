package hcmute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.entity.OrderDetailEntity;
import hcmute.repository.OrderDetailRepository;
import hcmute.service.IOrderDetailService;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService{
	@Autowired
	OrderDetailRepository orderDetailRepository;

	public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
		super();
		this.orderDetailRepository = orderDetailRepository;
	}

	@Override
	public <S extends OrderDetailEntity> S save(S entity) {
		return orderDetailRepository.save(entity);
	}

	@Override
	public <S extends OrderDetailEntity> List<S> saveAll(Iterable<S> entities) {
		return orderDetailRepository.saveAll(entities);
	}
}
