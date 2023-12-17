package com.group12.controller.user;

import com.group12.dto.UserDTO;
import com.group12.service.RollCallAndTimekeepingService;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class PersonalHomePage {
    @Autowired
    private UserService userService;
    @Autowired
    private RollCallAndTimekeepingService rollCallAndTimekeepingService;
    @GetMapping("/page/personal-home-page")
    public String personalHomePage(Model model, Principal principal) {
        String username = principal.getName();
        UserDTO currentUser = userService.getUserByUsername(username);
        UserDTO userDTO = rollCallAndTimekeepingService.getUserById(currentUser.getId());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("userDTO", userDTO);
        return "PersonalHomePage";
    }
}
