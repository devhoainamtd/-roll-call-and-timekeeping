package com.group12.controller;

import com.group12.dto.UserDTO;
import com.group12.service.RollCallAndTimekeepingService;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class UserDetailController {
    @Autowired
    private RollCallAndTimekeepingService rollCallAndTimekeepingService;
    @Autowired
    private UserService userService;
    @GetMapping("/user-detail/{id}")
    public String getUserById(Model model, @PathVariable Long id, Principal principal) {
        String username = principal.getName();
        UserDTO currentUser = userService.getUserByUsername(username);
        model.addAttribute("currentUser", currentUser);
        UserDTO userDTO = rollCallAndTimekeepingService.getUserById(id);
        model.addAttribute("userDTO", userDTO);
        return "userDetail";
    }
}
