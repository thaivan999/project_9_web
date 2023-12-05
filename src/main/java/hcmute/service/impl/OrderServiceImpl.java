package hcmute.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.entity.OrderEntity;
import hcmute.repository.OrderRepository;
import hcmute.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public <S extends OrderEntity> S save(S entity) {
		return orderRepository.save(entity);
	}
	
	
}
