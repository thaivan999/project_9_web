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
	private CustomUserDetailsService service;

	@Autowired
	IUserService userService;

	@Autowired
	private CustomOAuth2UserService oauthUserService;
	@Autowired
	private OAuthLoginSuccessHandler oauthLoginSuccessHandler;

	// @Autowired
	// private DatabaseLoginSuccessHandler databaseLoginSuccessHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider getDaoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(service);
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDaoAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors();
		http.authorizeRequests().antMatchers("/", "/login**").permitAll()
				.antMatchers("/home/**", "/security/**", "/oauth2/**", "/oauth/authorize",
						"/**/*.css", "/**/*.js")
				.permitAll().antMatchers("/admin/index","/admin/**", "/admin/branch/**").hasAuthority("ADMIN")
				.anyRequest().authenticated();

		http.formLogin().loginPage("/security/login").loginProcessingUrl("/security/login")
				.defaultSuccessUrl("/home", false).failureUrl("/security/login");
		// .successHandler(databaseLoginSuccessHandler);

		http.rememberMe().tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) // expired after 21 days
				.key("superhumanisnotsuperjustoverpowered").userDetailsService(service);
		http.logout().logoutUrl("/security/logout").logoutSuccessUrl("/security/login").clearAuthentication(true)
				.invalidateHttpSession(true).deleteCookies("JSESSIONID");

		http.exceptionHandling().accessDeniedPage("/security/unauthorized");

		http.oauth2Login().loginPage("/security/login").defaultSuccessUrl("/oauth2/login", true)
				.failureUrl("/security/login").authorizationEndpoint().baseUri("/oauth2/authorization").and()
				.userInfoEndpoint().userService(oauthUserService).and().successHandler(oauthLoginSuccessHandler);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

}
