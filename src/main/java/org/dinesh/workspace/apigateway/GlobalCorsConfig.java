package org.dinesh.workspace.apigateway;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author Dinesh Rajasekar
 */
@Configuration
public class GlobalCorsConfig {

	@Autowired
	private ConfigProps configProps;

	@Bean
	public CorsWebFilter getCorsConfig() {

		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(configProps.getAllowedOrigins() != null && !configProps.getAllowedOrigins().isEmpty()
				? configProps.getAllowedOrigins()
				: Arrays.asList("http://localhost:3002"));
		config.setAllowedMethods(configProps.getAllowedMethods() != null && !configProps.getAllowedMethods().isEmpty()
				? configProps.getAllowedMethods()
				: Arrays.asList("GET"));
		config.addAllowedHeader("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		return new CorsWebFilter(source);
	}

}

@Component
@RefreshScope
@ConfigurationProperties(prefix = "spring.cloud.gateway.globalcors.cors-configurations.'[/**]':")
class ConfigProps {

	private List<String> allowedOrigins;
	private List<String> allowedMethods;

	public List<String> getAllowedOrigins() {
		return allowedOrigins;
	}

	public void setAllowedOrigins(List<String> allowedOrigins) {
		this.allowedOrigins = allowedOrigins;
	}

	public List<String> getAllowedMethods() {
		return allowedMethods;
	}

	public void setAllowedMethods(List<String> allowedMethods) {
		this.allowedMethods = allowedMethods;
	}

}
