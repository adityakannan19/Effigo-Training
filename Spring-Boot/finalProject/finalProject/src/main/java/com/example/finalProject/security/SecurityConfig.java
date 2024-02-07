package com.example.finalProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	}

	@SuppressWarnings({ "removal" })
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(requests -> {
			try {
				requests.requestMatchers("/api/admin/**").hasRole("ADMIN").requestMatchers("/api/author/**")
						.hasRole("AUTHOR").requestMatchers("/api/**").authenticated().and().httpBasic(withDefaults());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
		return null;
	}
}
