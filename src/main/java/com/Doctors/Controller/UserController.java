package com.Doctors.Controller;

import com.Doctors.Payload.UserDto;
import com.Doctors.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/d1/Doctor")

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        UserDto dto = userService.addUser(userDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @PostMapping("/updatePassword/{username}")
    public ResponseEntity updatePassword( @PathVariable String username, @RequestBody UserDto userDto){
        UserDto updatePassword = userService.updatePassword(username, userDto);
        return new ResponseEntity(updatePassword,HttpStatus.OK);
    }
//    @PutMapping("/update")
//    public ResponseEntity<UserDto>updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
//        UserDto updated = userService.updateUser(id, userDto);
//        return ResponseEntity.ok(updated);


    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(id, userDto);
        return new ResponseEntity <>(updatedUser,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}