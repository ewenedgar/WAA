package edu.miu.cs.lab07.controllers;

import edu.miu.cs.lab07.models.User;
import edu.miu.cs.lab07.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public User registerUser(@RequestBody User user){
        return userService.saveUser(user);
    }

}
