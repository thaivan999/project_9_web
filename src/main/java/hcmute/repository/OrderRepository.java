package hcmute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.entity.BranchEntity;
import hcmute.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	// Statistics for each day of the current month
	@Query("SELECT o.orderDay, SUM(o.finalPrice) FROM OrderEntity o "
			+ "WHERE MONTH(o.orderDay) = MONTH(GETDATE()) "
			+ "AND YEAR(o.orderDay) = YEAR(GETDATE()) "
			+ "GROUP BY o.orderDay")
	List<Object[]> getRevenueByDay();
	
	// Statistics for each month of the current year
	@Query("SELECT MONTH(o.orderDay), SUM(o.finalPrice)FROM OrderEntity o "
			+ "WHERE YEAR(o.orderDay) = YEAR(GETDATE()) "
			+ "GROUP BY MONTH(o.orderDay)")
	List<Object[]> getRevenueByMonth();
	
	@Query("SELECT o FROM OrderEntity o WHERE o.customerByOrder.id = :userId")
    List<OrderEntity> findAllOrdersByUserId(Integer userId);
	
	List<OrderEntity> findByBranchByOrder(BranchEntity branchEntity);
}
