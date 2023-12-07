package hcmute.service;

import java.util.List;

import hcmute.entity.OrderEntity;

public interface IOrderService {

	<S extends OrderEntity> S save(S entity);

	List<OrderEntity> findAll();

	OrderEntity getById(Integer id);

}
