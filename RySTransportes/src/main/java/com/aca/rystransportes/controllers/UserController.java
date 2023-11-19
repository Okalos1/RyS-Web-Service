package com.aca.rystransportes.controllers;

import com.aca.rystransportes.services.impls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aca.rystransportes.models.dtos.UserInfo;
import com.aca.rystransportes.models.entities.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping()
    public List<User> showUser() {
        return userService.getAllUser();
    }
    
    @GetMapping("/me")
    public ResponseEntity<User> CurrentUser(UserInfo userInfo) {
		try {

            User user = userService.getUserAuthenticated();

            return new ResponseEntity<>(
                    user,
                    HttpStatus.OK
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUsers() {

        try {
            //User userAuth = userService.getUserAuthenticated();
            //System.out.println(userAuth.getName());

            List<User> users = userService.getAllUser();

            return new ResponseEntity<>(
                    users,
                    HttpStatus.OK
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
