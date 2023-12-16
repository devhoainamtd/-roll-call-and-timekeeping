package com.group12.controller.user;

import com.group12.dto.UserDTO;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ShowAllUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/show-all-user")
    public String getAllUsers(Model model, Principal principal) {
        String username = principal.getName();
        UserDTO currentUser = userService.getUserByUsername(username);
        model.addAttribute("currentUser", currentUser);

        List<UserDTO> listUser = userService.getAllUsers();
        model.addAttribute("listUser", listUser);
        return "showAllUser";
    }
}
