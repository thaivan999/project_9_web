package hcmute.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;


public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter{
	@Override
	public void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/decorators/user.jsp")
			   .addDecoratorPath("/admin/*", "/decorators/admin.jsp")
			   .addDecoratorPath("/manager/*", "/decorators/manager.jsp")
			   .addExcludedPath("/security*").addExcludedPath("/security/*");
	}
}
