package hcmute.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
    
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception{
//    	final List<GlobalAuthenticationConfigurerAdapter> configures = new ArrayList<>();
//    	configures.add(new GlobalAuthenticationConfigurerAdapter() {
//    		@Override
//    		public void configure(AuthenticationManagerBuilder auth) throws Exception{
//    			
//    		}
//    	});
//    	return auth.getAuthenticationManager();
//    }
//    
//    @Bean
//    public SecurityFilterChain filter(HttpSecurity http) throws Exception{
//    	return http
//    			.csrf().disable()
//    			.authorizeRequests()
//    			.antMatchers("/").hasAnyAuthority("USER", "ADMIN")
//    			.antMatchers("/home").hasAnyAuthority("USER", "ADMIN")
//    			.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
//    			.anyRequest().authenticated()
//    			.and()
//    			.httpBasic()
//    			.and()
//    			.formLogin().loginPage("/security/login").permitAll()
//    			.and()
//    			.logout().permitAll()
//    			.and()
//    			.exceptionHandling().accessDeniedPage("/security/unauthorized")
//    			.and()
//    			.build();
//    }
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/home", "/products/**", "/login", "/logout", "/register", "/error", "/process_register").permitAll()
//                .antMatchers("/admin/**","/admin/index").hasAuthority("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/security/login")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .loginProcessingUrl("/security/login")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/login?error=true")
//                .permitAll()
//                .and()
//                .oauth2Login().loginPage("/login").userInfoEndpoint().userService(oauthUserService).and().successHandler(oauthLoginSuccessHandler).and()
//                .logout().logoutSuccessUrl("/?logout=true")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .permitAll()
//                .and()
//                .csrf().disable();
//    }
//    
    
    
//     Configure HttpSecurity để cấu hình quy tắc bảo mật cho ứng dụng
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().cors();
		http.authorizeRequests()
			.antMatchers("/", "/login**", "/**").permitAll()
			.antMatchers("/home/**", "/security/**", "/security/verify/**", "/oauth2/**", "/oauth/authorize",  "/**/*.css", "/**/*.js").permitAll()
			.antMatchers("/admin/index").authenticated()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/**").hasAnyRole("USER")
			.anyRequest().authenticated();

		http.formLogin()
			.loginPage("/security/login")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/home", false)
			.failureUrl("/security/login/error");

		http.rememberMe()
			.tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) // expired after 21 days
			.key("superhumanisnotsuperjustoverpowered").userDetailsService(service);
		http.logout()
			.logoutUrl("/security/logout")
			.logoutSuccessUrl("/security/login")
			.clearAuthentication(true)
			.invalidateHttpSession(true).deleteCookies("JSESSIONID");

		http.exceptionHandling() 
			.accessDeniedPage("/security/unauthorized");

		http.oauth2Login()
			.loginPage("/security/login")
			.defaultSuccessUrl("/home", true)
			.failureUrl("/security/login/error")
			.authorizationEndpoint().baseUri("/oauth2/authorization").and()
			.userInfoEndpoint().userService(oauthUserService).and().successHandler(oauthLoginSuccessHandler);
	}
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/home", "/security/register", "/security/login").permitAll()
//                .antMatchers("/admin/**").hasAuthority("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/security/login")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .loginProcessingUrl("/security/login")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/login?error=true")
//                .permitAll()
//                .and()
//            .oauth2Login()
//                .loginPage("/login")
//                .userInfoEndpoint()
//                .userService(oauthUserService)
//                .and()
//                .successHandler(oauthLoginSuccessHandler)
//                .and()
//            .logout()
//                .logoutSuccessUrl("/?logout=true")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .permitAll()
//                .and()
//            .csrf().disable();
//    }
}
