package hcmute.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.entity.MilkTeaEntity;


@Repository
public interface MilkTeaRepository extends JpaRepository<MilkTeaEntity, Integer> {
//	List<MilkTeaEntity> findProductByTypeId(Integer id_type);
    @Query("SELECT mt FROM MilkTeaEntity mt WHERE id_type = :value")
    List<MilkTeaEntity> findAllByColumn(@Param("value") Integer value);

}
