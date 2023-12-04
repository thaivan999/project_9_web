package hcmute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.entity.MilkTeaEntity;
import hcmute.entity.MilkTeaTypeEntity;

@Repository
public interface MilkTeaTypeRepository extends JpaRepository<MilkTeaTypeEntity, Integer> {
	// @Query("SELECT mtt FROM MilkTeaTypeEntity mtt WHERE
	// mtt.milkTeaCategoryByMilkTeaType.idCategory = :value")
	// List<MilkTeaTypeEntity> findAllByColumn(@Param("value") Integer value);
	@Query("SELECT name FROM MilkTeaTypeEntity where id_category = :value")
	List<MilkTeaTypeEntity> findAllByColumn(@Param("value") Integer value);
}
