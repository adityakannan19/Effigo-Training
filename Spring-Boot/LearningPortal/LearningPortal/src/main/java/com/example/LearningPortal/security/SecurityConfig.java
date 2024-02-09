package com.example.LearningPortal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.LearningPortal.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
//extends WebSecurityConfiguration
public class SecurityConfig {
	@Bean
	public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails user = org.springframework.security.core.userdetails.User.withUsername("user")
				.password(passwordEncoder.encode("password")).roles("USER").build();

		UserDetails admin = org.springframework.security.core.userdetails.User.withUsername("admin")
				.password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").build();

		return new InMemoryUserDetailsManager(user, admin);
	}

	@SuppressWarnings("removal")
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/api").hasAnyAuthority("AUTHOR", "LEARNER", "ADMIN")
				.requestMatchers("/api/admin/**").hasAuthority("ADMIN").requestMatchers("/api/author/**")
				.hasAuthority("AUTHOR").requestMatchers("/delete/**").hasAuthority("ADMIN").anyRequest()
				.authenticated();
		//				.and().formLogin().permitAll().and().logout().permitAll().and().exceptionHandling()
		//				.accessDeniedPage("/403");
	}

	//	@Bean
	//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	//		return http.build();
	//	}
}