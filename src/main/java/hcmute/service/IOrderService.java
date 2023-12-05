package hcmute.service;

import hcmute.entity.OrderEntity;

public interface IOrderService {

	<S extends OrderEntity> S save(S entity);

}
