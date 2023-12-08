package hcmute.service;

import java.util.Optional;

import hcmute.entity.CustomerEntity;

public interface ICustomerService {

	Optional<CustomerEntity> findById(Integer id);

	<S extends CustomerEntity> S save(S entity);
}
