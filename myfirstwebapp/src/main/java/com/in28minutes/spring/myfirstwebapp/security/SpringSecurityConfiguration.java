package com.in28minutes.spring.myfirstwebapp.security;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

  @Bean
  public InMemoryUserDetailsManager createUserDetails() {



    UserDetails userDetail1 = createNewUser("omkar",
        "dummy");
    UserDetails userDetail2 = createNewUser("srushti",
        "duma");

    return new InMemoryUserDetailsManager(userDetail1,userDetail2);
  }

  private UserDetails createNewUser(String username, String password) {
    Function<String, String> passwordEncoder
        = input -> passwordEncoder().encode(input);

    UserDetails userDetails = User.builder()
        .passwordEncoder(passwordEncoder).username(username).password(password)
        .roles("USER", "ADMIN").build();
    return userDetails;
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return  new BCryptPasswordEncoder();
  }



  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

    httpSecurity.authorizeHttpRequests(
        auth -> auth.anyRequest().authenticated());

    httpSecurity.formLogin(Customizer.withDefaults());

    httpSecurity.csrf(csrf -> csrf.disable());
    // OR
    // http.csrf(AbstractHttpConfigurer::disable);

    httpSecurity.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

    return httpSecurity.build();
  }
}
