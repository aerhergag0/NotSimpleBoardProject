package com.rmrdo.notsimpleboardproject.config.security;

import com.rmrdo.notsimpleboardproject.exception.OAuth2AuthenticationException;
import com.rmrdo.notsimpleboardproject.user.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final CustomOAuth2UserService customOAuth2UserService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(CsrfConfigurer::disable)
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
						.requestMatchers("/**").permitAll()
						.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults())
				.oauth2Login(oauth2 -> oauth2.userInfoEndpoint(infoEndpoint -> infoEndpoint.userService(customOAuth2UserService))
						.failureHandler((request, response, exception) -> {
							throw new OAuth2AuthenticationException(exception.getMessage());
						}))
		;

		return httpSecurity.build();
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
