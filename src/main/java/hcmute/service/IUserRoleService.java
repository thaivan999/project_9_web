package hcmute.service;
import java.util.List;

import hcmute.entity.UserRoleEntity;

public interface IUserRoleService {
    List<UserRoleEntity> findRolesOfAdministrators();

    List<UserRoleEntity> findAll();

    UserRoleEntity create(UserRoleEntity auth);

    void delete(Integer id);
}
