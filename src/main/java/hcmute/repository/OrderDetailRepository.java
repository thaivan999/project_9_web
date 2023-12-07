package hcmute.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.embeddedId.OrderDetailId;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.OrderDetailEntity;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailId>{
	@Query(value = "SELECT * FROM order_detail WHERE id_milk_tea = :milkTeaID", nativeQuery = true)
    List<OrderDetailEntity> findOrderDetailsByIDMilkTea(@Param("milkTeaID") int milkTeaID);
}
