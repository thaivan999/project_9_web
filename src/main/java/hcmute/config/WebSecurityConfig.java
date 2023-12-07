package hcmute.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import hcmute.security.CustomUserDetailsService;
import hcmute.security.oauth2.CustomOAuth2UserService;
import hcmute.security.oauth2.OAuthLoginSuccessHandler;
import hcmute.service.IUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    IUserService userService;

    @Autowired
    private CustomUserDetailsService service;

    @Autowired
    private CustomOAuth2UserService oauthUserService;
    @Autowired
    private OAuthLoginSuccessHandler oauthLoginSuccessHandler;

    // Bean để tạo PasswordEncoder sử dụng BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean để tạo DaoAuthenticationProvider, cung cấp thông tin xác thực từ CustomUserDetailsService và sử dụng BCryptPasswordEncoder
    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(service);
        return provider;
    }

    // Configure AuthenticationManagerBuilder để sử dụng DaoAuthenticationProvider
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getDaoAuthenticationProvider());
    }

    // Configure HttpSecurity để cấu hình quy tắc bảo mật cho ứng dụng
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors();
        http.authorizeRequests()
            // Cấu hình quy tắc truy cập kể cả chưa đăng nhập
            .antMatchers("/**", "/login**").permitAll()
            .antMatchers(
                "/home/**",
                "/security/**",
                "/admin/index/**",
                "/payment/order/**",
                "/admin/branch/saveOrUpdate/**",
                "/security/verify/**",
                "/security/register",
                "/oauth2/**",
                "/oauth/authorize"
            ).permitAll()
            .antMatchers("/admin/**").hasAnyRole("ADMIN")
            //đối với các yêu cầu còn lại thì cần đăng nhập
            .anyRequest().authenticated();

        // Cấu hình xác thực form login
        http.formLogin()
            .loginPage("/security/login")
            .loginProcessingUrl("/security/login")
            .defaultSuccessUrl("/home", false)
            .failureUrl("/security/login/error")
            .permitAll();

        // Cấu hình remember me
        http.rememberMe()
            .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) // expired after 21 days
            .key("superhumanisnotsuperjustoverpowered")
            .userDetailsService(service);

        // Cấu hình logout
        http.logout()
            .logoutUrl("/security/logout")
            .logoutSuccessUrl("/security/login")
            .clearAuthentication(true)
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");

        // Cấu hình xử lý exception handling
        http.exceptionHandling()
            .accessDeniedPage("/security/unauthorized");

        // Cấu hình xác thực OAuth2
        http.oauth2Login()
            .loginPage("/security/login")
            .defaultSuccessUrl("/home", true)
            .failureUrl("/security/login/error")
            .authorizationEndpoint()
            .baseUri("/oauth2/authorization")
            .and()
            .userInfoEndpoint()
            .userService(oauthUserService)
            .and()
            .successHandler(oauthLoginSuccessHandler);
    }

    // Configure WebSecurity để bỏ qua các request không cần xác thực (ví dụ: các file tĩnh)
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
