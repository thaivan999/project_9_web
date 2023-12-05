package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.entity.OrderDetailEntity;
import hcmute.entity.OrderDetailPKEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailPKEntity>{

}
