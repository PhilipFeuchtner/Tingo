package de.uniko.iwm.config;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan(basePackages = { "de.uniko.iwm" })
public class RootConfig {

	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		// ppc.setLocations(new Resource[] {
		// new ClassPathResource("/persistence.properties"),
		// new ClassPathResource("/application.properties") });

		ppc.setLocation(new ClassPathResource("/persistence.properties"));

		return ppc;
	}
}