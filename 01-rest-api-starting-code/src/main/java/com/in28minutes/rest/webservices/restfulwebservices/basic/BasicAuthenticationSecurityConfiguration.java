package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthenticationSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http
				.authorizeHttpRequests(auth -> 
					auth
					.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
					.anyRequest()
					.authenticated()) // 미인증시 요청거부

				.httpBasic(Customizer.withDefaults()) // 요청거부상태창대신 로그인 인증창

				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.csrf().disable().build();

	}

}
