package hcmute.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import hcmute.entity.MilkTeaEntity;

@Repository
public interface MilkTeaRepository extends JpaRepository<MilkTeaEntity, Integer> {
	// find a product by id
	@Query("SELECT mt FROM MilkTeaEntity mt WHERE mt.milkTeaTypeByMilkTea.idType = :typeId")
	List<MilkTeaEntity> findAllByTypeId(int typeId);
	Optional<MilkTeaEntity> findByIdMilkTea(int id);
	List<MilkTeaEntity> findAll();
	//top products
	@Query(value = "SELECT * FROM milk_tea WHERE id_milk_tea IN " +
		            "(SELECT TOP 4 id_milk_tea FROM order_detail GROUP BY id_milk_tea ORDER BY SUM(quantity) DESC)",
		            nativeQuery = true)
	List<MilkTeaEntity> findFourProductsOutstanding();
}
