//Đây là một cấu hình Spring MVC (Model-View-Controller), được sử dụng để cấu hình các điều hướng và khai báo các view mặc định.
package hcmute.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/security/login").setViewName("security/login");
	}

}
