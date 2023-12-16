package com.group12.controller;

import com.group12.dto.UserDTO;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String homePage(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            UserDTO currentUser = userService.getUserByUsername(username);
            model.addAttribute("currentUser", currentUser);
        }
        return "index";
    }
}
