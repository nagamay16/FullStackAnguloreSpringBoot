package com.springboot.rest.webservices.springbootangular.jwt;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "reyansh",
        "$2a$10$XZroINc08SXR.IOTdvgCUemB.LvG0h.8QnaASF5fNgZE1jQ0yiYm.", "ROLE_USER_2"));
    inMemoryUserList.add(new JwtUserDetails(2L, "yuvan",
            "$2a$10$5e8BTpRTEoOnSqyEiPk7Uu01DDmwEXgHpHOcIRf6EMTaFFktQnhPC", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


