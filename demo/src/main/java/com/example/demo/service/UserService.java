package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save();

    List<User> fetchUserList();

    void deleteUser(User user);

    Optional<User> getUserById(Long id);
}
