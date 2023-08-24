package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
//@RequestMapping("/admin")
public class AdminController {

    public final UserService userService;
    public final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin/users")
    public String usersPage(ModelMap model, Principal principal,@ModelAttribute("addUser") User user) {
        model.addAttribute("usersList", userService.listUsers());
        model.addAttribute("currentUser", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("addUser", new User());
        return "users";
    }

    @PostMapping("/admin/users")
    public String create(@ModelAttribute("addUser") User user, @RequestParam String role) {
        userService.add(user, role);
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/users/{id}")
    public String update(@ModelAttribute("userUpdate") User user, @RequestParam String role) {
        userService.updateUser(user, role);
        return "redirect:/admin/users";
    }

    @PostMapping(value = "/admin/users/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/user/{id}")
    public String userPage(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }
}
