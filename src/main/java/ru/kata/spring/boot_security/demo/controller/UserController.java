package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
public class UserController {

    public final UserService userService;
    public final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/user")
    public String userPage(ModelMap model, Principal principal) {
        model.addAttribute("user", (ru.kata.spring.boot_security.demo.model.User) userService.loadUserByUsername(principal.getName()));
        return "user";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
