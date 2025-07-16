package com.project.app.service;

import java.util.List;
import java.util.Optional;

import com.project.app.entity.User;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
