package com.service;

import com.models.Person;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserResource {
    void save(Person user);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
