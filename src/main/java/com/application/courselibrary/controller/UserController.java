package com.application.courselibrary.controller;

import com.application.courselibrary.entity.User;
import com.application.courselibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    private String findAllUsers(Model model) {
        model.addAttribute( "users", userService.findAllUsers() );
        return "users";
    }

    @GetMapping("/remove-user/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.deleteUser( id );
        model.addAttribute( "users", userService.findAllUsers() );
        return "users";
    }

    @GetMapping("/update-user/{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        model.addAttribute( "user", userService.findUserById( id ) );
        return "update-user";
    }

    @PostMapping("/update-user/{id}")
    public String saveUser(@PathVariable Long id, User user, BindingResult bidingResult, Model model) {
        if (bidingResult.hasErrors())
            return "update-user";
        userService.updateUser( user );
        model.addAttribute( "users", userService.findAllUsers() );
        return "redirect:/users";
    }

    @GetMapping("/add-user")
    public String showCreateUser(User user) {
        return "add-user";
    }

    @PostMapping("/save-user")
    public String saveUser(User user, BindingResult bidingResult, Model model) {
        if (bidingResult.hasErrors())
            return "add-user";
        userService.createUser( user );
        model.addAttribute( "users", userService.findAllUsers() );
        return "redirect:/users";
    }
}
