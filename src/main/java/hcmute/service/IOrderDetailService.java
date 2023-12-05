package hcmute.service;

import java.util.List;

import hcmute.entity.OrderDetailEntity;

public interface IOrderDetailService {

	<S extends OrderDetailEntity> List<S> saveAll(Iterable<S> entities);

	<S extends OrderDetailEntity> S save(S entity);

}
