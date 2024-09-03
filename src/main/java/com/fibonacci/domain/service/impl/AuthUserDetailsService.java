package com.fibonacci.domain.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;

@Service
@CrossOrigin
public class AuthUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return new User(s,"FIBONACCI2024",new ArrayList<>());
  }
}
