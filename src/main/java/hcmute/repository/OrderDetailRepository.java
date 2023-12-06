package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.entity.OrderDetailEntity;
import hcmute.entity.OrderDetailPKEntity;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailPKEntity>{

}
