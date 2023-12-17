package com.group12.controller.user;

import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DeleteUserController {
    @Autowired
    private UserService userService;

    @PostMapping("/delete-user")
    public ResponseEntity<?> deleteUser(@RequestBody Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("Delete User Successffly!.");
    }
}
