package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping(value = "/users")
//    public String allUsers(Model model) {
//        List<User> users = userService.listUsers();
////        model.addAttribute("usersList", users);
////        User loggedInUser = (User) SecurityContextHolder.getContext()
////                .getAuthentication().getPrincipal();
////        model.addAttribute("loggedInUser", loggedInUser);
//        return "users";
//    }
}