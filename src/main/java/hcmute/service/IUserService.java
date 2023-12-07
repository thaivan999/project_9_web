package hcmute.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import hcmute.entity.UserEntity;

public interface IUserService {

    Optional<UserEntity> findById(Integer id);

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    UserEntity save(UserEntity user);

    UserEntity update(UserEntity user);

    void deleteByUsername(String id);

    List<UserEntity> findAll();

    List<UserEntity> getAdministators();

    void register(UserEntity user, String url) throws MessagingException;

    void sendVerifyEmail(UserEntity user, String url) throws MessagingException;

    boolean verify(String verifyCode);

    void processOAuthPostLogin(String username, String email, String image, String oauth2ClientName);

    void updateAuthenticationTypeOAuth(String username, String oauth2ClientName);

    void updateAuthenticationTypeDB(String username, String oauth2ClientName);
}
