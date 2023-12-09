package hcmute.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private CustomOAuth2UserService customOAuth2UserService;

	@Autowired
	private OAuthLoginSuccessHandler oauthLoginSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/", "/login**", "/**").permitAll()
			.antMatchers("/home/**", "/security/**", "/security/verify/**", "/oauth2/**", "/oauth/authorize",  "/**/*.css", "/**/*.js").permitAll()
			.antMatchers("/admin/index").authenticated()
			.antMatchers("/admin/**", "/admin/branch/**").hasAnyRole("ADMIN")
			.antMatchers("/**").hasAnyRole("USER")
			.anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/security/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
            .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .and()
                .successHandler(oauthLoginSuccessHandler)
                .and()
            .logout()
                .logoutSuccessUrl("/?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
            .csrf().disable();
    }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
