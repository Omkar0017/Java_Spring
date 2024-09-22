package com.in28minutes.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

    httpSecurity.authorizeHttpRequests(
        auth -> auth.anyRequest().authenticated()
    ); // Authenticate all request
    httpSecurity.httpBasic(Customizer.withDefaults()); // Show basic authentication page
    httpSecurity.csrf().disable(); // disable csrf
    return httpSecurity.build();
  }
}
