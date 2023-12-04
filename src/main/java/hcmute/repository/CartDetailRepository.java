package hcmute.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.entity.CartDetailEntity;

public interface CartDetailRepository extends JpaRepository<CartDetailEntity, Integer>{
=======
import java.util.List;
>>>>>>> 9a5e4c5a7ac1022044de3c099dba7bc65bdb9261

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.embeddedId.CartDetailId;
import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetailEntity, CartDetailId> {
	List<CartDetailEntity> findByCartByCartDetailIdCart(int idCart);

    @Query("SELECT cd.milkTeaByCartDetail FROM CartDetailEntity cd WHERE cd.cartByCartDetail.idCart = :idCart")
    List<MilkTeaEntity> findMilkTeaByCartId(int idCart);
}
