package com.spc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class CustomSecurity
{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
 
	//security
	@Bean
	public UserDetailsService userDetailService() {
		
		UserDetails normalUser = User.withUsername("normaluser")
				.password(passwordEncoder().encode("normal"))
				.roles("NORMAL")
				.build();
		
		UserDetails adminUser = User.withUsername("adminuser")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		//for returning
		
		 InMemoryUserDetailsManager inmemory = new InMemoryUserDetailsManager(normalUser,adminUser);
	
		 return inmemory;
	}
	
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable()
		
		 .authorizeHttpRequests()
		 .requestMatchers("/sc/admin")
		 .hasRole("ADMIN")
		 .requestMatchers("/sc/normal")
		 .hasRole("NORMAL")
		 .requestMatchers("/sc/public")
		 .permitAll()
		 .anyRequest()
		 .authenticated()
		 .and()
		 .formLogin();
		 
		
		return httpSecurity.build();
		
	}
	
	
	
	
}


