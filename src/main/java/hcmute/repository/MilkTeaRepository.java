package hcmute.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.entity.MilkTeaEntity;

@Repository
public interface MilkTeaRepository extends JpaRepository<MilkTeaEntity, Integer> {
	// find a product by id
	@Query("SELECT mt FROM MilkTeaEntity mt WHERE mt.milkTeaTypeByMilkTea.idType = :typeId")
	List<MilkTeaEntity> findAllByTypeId(int typeId);

	Optional<MilkTeaEntity> findByIdMilkTea(int id);

	@Query(value = "SELECT * FROM milk_tea WHERE id_milk_tea IN "
			+ "(SELECT TOP 5 id_milk_tea FROM order_detail GROUP BY id_milk_tea ORDER BY SUM(quantity) DESC)", nativeQuery = true)
	List<MilkTeaEntity> findFiveProductOutstanding();

	List<MilkTeaEntity> findAll();
	Page<MilkTeaEntity> findAll(Pageable pageable);
	
	// find relevant products
	// choose 4 products has the same type except the current product
	@Query("SELECT m FROM MilkTeaEntity m WHERE m.milkTeaTypeByMilkTea.idType = :typeId AND m.idMilkTea <> :milkTeaId")
	List<MilkTeaEntity> findRelevantProducts(@Param("typeId") int typeId, @Param("milkTeaId") int milkTeaId);

	long count();

	Page<MilkTeaEntity> findBynameContaining(String name, Pageable pageable);
	
	@Query(value = "SELECT * FROM milk_tea WHERE LOWER(cast(name as varchar(1000)) collate SQL_Latin1_General_Cp1251_CS_AS) LIKE LOWER(CONCAT('%', cast(:name as varchar(1000)) collate SQL_Latin1_General_Cp1251_CS_AS, '%'))", nativeQuery = true)
	List<MilkTeaEntity> findByNameContaining(@Param("name") String name);
	
	@Query(value = "SELECT * FROM milk_tea WHERE LOWER(cast(name as varchar(1000)) collate SQL_Latin1_General_Cp1251_CS_AS) LIKE LOWER(CONCAT('%', cast(:name as varchar(1000)) collate SQL_Latin1_General_Cp1251_CS_AS, '%')) ORDER BY cost ASC", nativeQuery = true)
	List<MilkTeaEntity> findByNameContainingAndSortAscendingByCost(@Param("name") String name);
	
	@Query(value = "SELECT * FROM milk_tea WHERE LOWER(cast(name as varchar(1000)) collate SQL_Latin1_General_Cp1251_CS_AS) LIKE LOWER(CONCAT('%', cast(:name as varchar(1000)) collate SQL_Latin1_General_Cp1251_CS_AS, '%')) ORDER BY cost DESC", nativeQuery = true)
	List<MilkTeaEntity> findByNameContainingAndSortDescendingByCost(@Param("name") String name);

	@Query("SELECT COUNT(mt) FROM MilkTeaEntity mt WHERE mt.milkTeaTypeByMilkTea.idType = :typeId")
	int countByTypeId(int typeId);
	
	@Query(value = "SELECT COUNT(*) FROM milk_tea WHERE LOWER(cast(name as varchar(1000)) collate SQL_Latin1_General_Cp1251_CS_AS) LIKE LOWER(CONCAT('%', cast(:name as varchar(1000)) collate SQL_Latin1_General_Cp1251_CS_AS, '%'))", nativeQuery = true)
	int countByNameContaining(@Param("name") String name);
	
	@Query("SELECT mt FROM MilkTeaEntity mt WHERE mt.milkTeaTypeByMilkTea.idType = :idType")
	Page<MilkTeaEntity> findAllByTypeId(int idType, Pageable pageable);
	
//	@Query(value = "SELECT * FROM milk_tea WHERE LOWER(cast(name as varchar(1000)) collate SQL_Latin1_General_Cp1251_CS_AS) LIKE LOWER(CONCAT('%', cast(:name as varchar(1000)) collate SQL_Latin1_General_Cp1251_CS_AS, '%'))", nativeQuery = true)
//	Page<MilkTeaEntity> findByNameContaining(@Param("name") String name,  Pageable pageable);
	
	Page<MilkTeaEntity> findByNameContaining(String name, Pageable pageable);
}
