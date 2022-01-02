


package com.example.testdemo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;




@Configuration
public class SecurityConfiguration {

	@Bean
	MapReactiveUserDetailsService userDetailsService() {
		// @formatter:off
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("SETUP")
				.build();
		// @formatter:on
		return new MapReactiveUserDetailsService(user);
	}

}
