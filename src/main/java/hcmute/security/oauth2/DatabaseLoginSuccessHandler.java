package hcmute.security.oauth2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import hcmute.security.CustomUserDetails;
import hcmute.service.IUserService;



@Component
public class DatabaseLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
    @Autowired IUserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        userService.updateAuthenticationTypeDB(userDetails.getUsername(), "database");
        getRedirectStrategy().sendRedirect(request, response, "/home");
    }
}
