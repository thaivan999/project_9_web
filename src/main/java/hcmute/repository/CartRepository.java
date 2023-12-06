package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.entity.CartEntity;
@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer>{
}
