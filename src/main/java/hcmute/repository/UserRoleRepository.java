package hcmute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hcmute.entity.UserEntity;
import hcmute.entity.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
    @Query("SELECT DISTINCT a FROM UserRoleEntity a WHERE a.user IN ?1")
    List<UserRoleEntity> authoritiesOf(List<UserEntity> accounts);
}
