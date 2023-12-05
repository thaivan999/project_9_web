package hcmute.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.entity.MilkTeaEntity;

@Repository
public interface MilkTeaRepository extends JpaRepository<MilkTeaEntity, Integer> {
	// find a product by id
	Optional<MilkTeaEntity> findByIdMilkTea(int id);
}
