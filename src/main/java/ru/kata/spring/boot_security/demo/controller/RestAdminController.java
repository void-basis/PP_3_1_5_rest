package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.rmi.NoSuchObjectException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class RestAdminController {

    public final UserService userService;
    public final RoleService roleService;

    public RestAdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

//    @GetMapping(value = "/admin/users")
//    public List<User> allUsers() {
//        List<User> allUsers = userService.listUsers();
//        return allUsers;
//    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> users = userService.listUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @GetMapping(value = "/admin/users/{id}")
//    public User userPage(@PathVariable("id") long id) {
//        return userService.getUser(id);
//    }

    @GetMapping(value = "/admin/users/{id}")
    public ResponseEntity<User> getOneUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @PostMapping("/admin/users")
//    public User create(@RequestBody User user) {
//        userService.add(user);
//        return user;
//    }

    @PostMapping("/admin/users")
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @DeleteMapping(value = "/admin/users/{id}")
//    public String deleteUser(@PathVariable("id") long id) throws NoSuchObjectException {
//        User user = userService.getUser(id);
//        if(user == null) {
//            throw new NoSuchObjectException("In data base was no user with that id");
//        }
//        userService.deleteUserById(id);
//        return "user with id " + id + " is deleted";
//    }

    @DeleteMapping(value = "/admin/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) throws NoSuchObjectException {
        User user = userService.getUser(id);
        if(user == null) {
            throw new NoSuchObjectException("In data base was no user with that id");
        }
        userService.deleteUserById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

//    @PutMapping("/admin/users")
//    public User update(@RequestBody User user) {
//        userService.updateUser(user);
//        return user;
//    }

    @PutMapping("/admin/users")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping(value = "/admin/users")
//    public String usersPage(ModelMap model, Principal principal,@ModelAttribute("addUser") User user) {
//        model.addAttribute("usersList", userService.listUsers());
//        model.addAttribute("currentUser", userService.loadUserByUsername(principal.getName()));
//        model.addAttribute("addUser", new User());
//        return "users";
//    }

//    @PostMapping("/admin/users")
//    public String create(@ModelAttribute("addUser") User user, @RequestParam String role) {
//        userService.add(user, role);
//        return "redirect:/admin/users";
//    }
//
//    @PostMapping("/admin/users/{id}")
//    public String update(@ModelAttribute("userUpdate") User user, @RequestParam String role) {
//        userService.updateUser(user, role);
//        return "redirect:/admin/users";
//    }
//
//    @PostMapping(value = "/admin/users/{id}/delete")
//    public String deleteUser(@PathVariable("id") long id) {
//        userService.deleteUserById(id);
//        return "redirect:/admin/users";
//    }
//
//    @GetMapping(value = "/user/{id}")
//    public String userPage(ModelMap model, @PathVariable("id") long id) {
//        model.addAttribute("user", userService.getUser(id));
//        return "user";
//    }
}
