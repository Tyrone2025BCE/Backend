package com.bce.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bce.demo.entities.User;
import com.bce.demo.services.UserService;


@CrossOrigin("*")
@RequestMapping("/api/users")
@RestController

//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("/api/users")


public class UserController {


@Autowired
private UserService userService;

    
     @GetMapping("")
    public List<User> getAllUser(){
    return userService.findAll();
     }


@PostMapping("/add")
public User createUser(@RequestBody User user){
    return userService.nuevo(user);
}


@PostMapping("/add-users")
public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users){
  return new ResponseEntity<List<User>>(userService.createUsers(users),
  HttpStatus.CREATED);
}



@GetMapping("/{userId}")
public User getUser(@PathVariable("userId") Integer userId){
    return userService.getUserById(userId);
}


@PutMapping("/update")
public User updateUser(@RequestBody User user) {
    return userService.actualizar(user);
}


@DeleteMapping  ("/delete/{userId}")
public ResponseEntity<User> deleteUser(@PathVariable("userId")Integer userId) {
    User deletedUser = userService.deleteUser(userId);
    return ResponseEntity.ok(deletedUser);
}



}
