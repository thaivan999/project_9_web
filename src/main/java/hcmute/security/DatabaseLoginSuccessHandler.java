package hcmute.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import hcmute.service.IUserService;

@Component
public class DatabaseLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
    @Autowired IUserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        //Lấy thông tin người dùng
    	CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        //Thực hiện cập nhật loại xác thực trong csdl
    	userService.updateAuthenticationTypeDB(userDetails.getUsername(), "database");
        //Chuyển hướng
    	getRedirectStrategy().sendRedirect(request, response, "/home");
    }
}
