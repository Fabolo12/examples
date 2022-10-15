package com.service;

import com.models.Person;
import com.models.Role;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findPersonByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void save(Person user) {
        if (user.getPassword() == null) {
            throw new IllegalArgumentException("Password is incorrect");
        }
        if (userRepository.findPersonByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(user.getEmail().equalsIgnoreCase("admin") ? Role.ADMIN : Role.USER);
        userRepository.save(user);
    }
}
