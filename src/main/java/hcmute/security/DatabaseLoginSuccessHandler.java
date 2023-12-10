package hcmute.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import hcmute.entity.UserEntity;
import hcmute.model.UserModel;
import hcmute.service.IUserService;

@Component
public class DatabaseLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    IUserService userService;
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        String username = authentication.getName();
        Optional<UserEntity> userOpt = userService.findByUsername(username);

        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            int userId = user.getId();

            // Lưu userId vào cookie
            Cookie userIdCookie = new Cookie("USER_ID", String.valueOf(userId));
            userIdCookie.setMaxAge(24 * 60 * 60);
            userIdCookie.setPath("/");
            response.addCookie(userIdCookie);
        }

        // Lấy thông tin người dùng
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        // Thực hiện cập nhật loại xác thực trong csdl
        userService.updateAuthenticationTypeDB(userDetails.getUsername(), "database");
        // Chuyển hướng
        getRedirectStrategy().sendRedirect(request, response, "/home");
    }
}