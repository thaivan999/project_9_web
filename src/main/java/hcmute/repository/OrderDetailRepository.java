package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.embeddedId.OrderDetailId;
import hcmute.entity.OrderDetailEntity;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailId>{

}
