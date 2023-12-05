package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

}
