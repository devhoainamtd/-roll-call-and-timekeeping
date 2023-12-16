package com.group12.controller.user;

import com.group12.dto.UpdateUserRequest;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UpdateUserController {
    @Autowired
    private UserService userService;

    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest request) {

        return null;
    }
}
