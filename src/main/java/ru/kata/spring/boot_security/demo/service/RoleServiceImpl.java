package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Component
public class RoleServiceImpl implements RoleService{
    public RoleDao roleDao;
    @Override
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }
}
