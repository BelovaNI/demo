package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save() {
        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");
        User user1 = new User("user", "1234", Collections.singleton(role1));
        User admin = new User("admin", "qwerty", Collections.singleton(role2));
        userRepository.save(user1);
        userRepository.save(admin);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void deleteUser(User user) {
     userRepository.delete(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
