package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{

}
