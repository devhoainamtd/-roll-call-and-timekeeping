package com.group12.controller.user;

import com.group12.dto.UserDTO;
import com.group12.service.RollCallAndTimekeepingService;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

@Controller
public class AddUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RollCallAndTimekeepingService rollCallAndTimekeepingService;

    @GetMapping("/add-page")
    public String addUser(Model model, Principal principal) {
        String username = principal.getName();
        UserDTO currentUser = userService.getUserByUsername(username);
        model.addAttribute("currentUser", currentUser);
        return "AddUser";
    }

    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return ResponseEntity.ok().body("Successfull!...");
    }

}
