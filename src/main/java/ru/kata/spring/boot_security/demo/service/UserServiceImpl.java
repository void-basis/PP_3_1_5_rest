package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class UserServiceImpl implements UserService {

    private final UserDao dao;
    private final RoleDao roleDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserDao dao, RoleDao roleDao) {
        this.dao = dao;
        this.roleDao = roleDao;

    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public User getUser(long id) {
        return dao.getUser(id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void add(User user, String role) {
        if (role.equalsIgnoreCase("role_admin")) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.getById(3L));
            user.setRoles(roles);
        }
        if (role.equalsIgnoreCase("role_user")) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.getById(2L));
            user.setRoles(roles);
        }
        if (role.equalsIgnoreCase("role_user,role_admin")) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.getById(3L));
            roles.add(roleDao.getById(2L));
            user.setRoles(roles);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        dao.add(user);
    }

    @Override
    public void updateUser(User user, String role) {
        if (role.equalsIgnoreCase("role_admin")) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.getById(3L));
            user.setRoles(roles);
        }
        if (role.equalsIgnoreCase("role_user")) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.getById(2L));
            user.setRoles(roles);
        }
        if (role.equalsIgnoreCase("role_user,role_admin")) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.getById(3L));
            roles.add(roleDao.getById(2L));
            user.setRoles(roles);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        dao.updateUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        dao.deleteUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return dao.listUsers();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.findByUsername(username);       //username == email
        if (user == null) {
            throw new UsernameNotFoundException("User not found bitch!!!");
        }
        return new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getRoles(), user.getAge());
    }
}

