package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void add(User user);

    User getUser(long id);

    void deleteUserById(long id);

    List<User> listUsers();

    void updateUser(User user);

    void add(User user, String role);
    void updateUser(User user, String role);

}
