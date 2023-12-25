package com.group12.controller.user;

import com.group12.dto.UpdateUserRequest;
import com.group12.dto.UserDTO;
import com.group12.service.RollCallAndTimekeepingService;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

@Controller
public class UpdateUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RollCallAndTimekeepingService rollCallAndTimekeepingService;

    @GetMapping("/personal-information/{id}")
    public String personalHomePage(Model model, @PathVariable Long id, Principal principal) {
        UserDTO userDTO = rollCallAndTimekeepingService.getUserById(id);

        model.addAttribute("userDTO", userDTO);
        return "UpdateUser";
    }
    @PostMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest request) {
        userService.updateUser(request);
        return ResponseEntity.ok().body("Succeess!");
    }
}
