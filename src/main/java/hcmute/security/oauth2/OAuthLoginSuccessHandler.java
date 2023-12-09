package hcmute.security.oauth2;

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
public class OAuthLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    IUserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        //Lấy thông tin người dung từ đối tượng Authentication
    	CustomOAuth2User oauth2User = (CustomOAuth2User) authentication.getPrincipal();
        //Với đối tượng đó lấy thông tin clientName, username, email
    	String oauth2ClientName = oauth2User.getOauth2ClientName();
        String username = oauth2User.getName();
        String email = oauth2User.getEmail();
        //Set thông tin người dùng xuống csdl
        userService.processOAuthPostLogin(username, email, oauth2ClientName);
        //Cập nhật thông tin người dùng xuống csdl
        userService.updateAuthenticationTypeOAuth(email, oauth2ClientName);
        //Chuyển hướng
        getRedirectStrategy().sendRedirect(request, response, "/home");
    }
}
