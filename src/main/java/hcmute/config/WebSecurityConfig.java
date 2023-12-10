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
import hcmute.security.DatabaseLoginSuccessHandler;
import hcmute.security.oauth2.CustomOAuth2UserService;
import hcmute.security.oauth2.OAuthLoginSuccessHandler;
import hcmute.service.IUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService service;

	@Autowired
	IUserService userService;

	@Autowired
	private CustomOAuth2UserService oauthUserService;
	@Autowired
	private OAuthLoginSuccessHandler oauthLoginSuccessHandler;

	//Phương thức này trả về một bean của PasswordEncoder để sử dụng trong việc mã hóa mật khẩu
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//Cơ chế xác thực trong Spring Security
	@Bean
	public DaoAuthenticationProvider getDaoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		//Cấu hình mã hóa mật khẩu
		provider.setPasswordEncoder(passwordEncoder());
		//Lấy thông tin người dùng từ cơ sở dữ liệu
		provider.setUserDetailsService(service);
		return provider;
	}

	//Cấu hình quản lý xác thực
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDaoAuthenticationProvider());
	}
	
	//Cấu hình loại bỏ một số yêu cầu xác thực cho các file tĩnh
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Cấu hình bảo mật HTTP
		http.csrf().disable().cors();
		//Phân quyền
		http.authorizeRequests()
			//Không cần xác thực
			.antMatchers("/", "/login**").permitAll()
			.antMatchers(
					"/home/**", 
					"/security/**", 
					"/api/places", 
					"/security/verify/**", 
					"/oauth2/**", 
					"/oauth/authorize",
					"/**/*.css", 
					"/**/*.js"
			).permitAll()
			//Phải có quyền ADMIN
			.antMatchers(
					"/admin/index",
					"/admin/**", 
					"/admin/branch/**"
			).hasAuthority("ADMIN")
			//Đường dẫn còn phải phải đăng nhập
			.anyRequest().authenticated();

		//Cấu hình trang đăng nhập
		http.formLogin()
			.loginPage("/security/login")
			.usernameParameter("username")
            .passwordParameter("password")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/home", false)
			.failureUrl("/security/login");
		
		//Cấu hình đăng nhập oauth2
		http.oauth2Login()
			.loginPage("/security/login")
			.defaultSuccessUrl("/oauth2/login", true)
			.failureUrl("/security/login")
			.authorizationEndpoint().baseUri("/oauth2/authorization")
			.and()
			.userInfoEndpoint().userService(oauthUserService)
			.and()
			.successHandler(oauthLoginSuccessHandler);
		
		//Cấu hình remember me
		http.rememberMe()
			.tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) // expired after 21 days
			.key("superhumanisnotsuperjustoverpowered")
			.userDetailsService(service);
		
		//Cấu hình đăng xuất
		http.logout()
			.logoutUrl("/security/logout")
			.logoutSuccessUrl("/security/logout/success")
			.clearAuthentication(true)
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID");
		
		//Xử lý khi người dùng không có quyền truy cập
		http.exceptionHandling()
			.accessDeniedPage("/security/unauthorized");
	}
}
