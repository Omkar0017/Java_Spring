package com.in28minutes.spring.myfirstwebapp.security;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
}
