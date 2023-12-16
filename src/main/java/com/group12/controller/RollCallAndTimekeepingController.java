package com.group12.controller;

import com.group12.dto.RollCallAndTimekeepingRequest;
import com.group12.dto.UserDTO;
import com.group12.service.RollCallAndTimekeepingService;
import com.group12.service.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RollCallAndTimekeepingController {

    @Autowired
    private RollCallAndTimekeepingService rollCallAndTimekeepingService;
    @Autowired
    private UserService userService;

    @GetMapping("/roll-call-and-timekeeping-detail/{id}")
    public String getRollCallAndTimeKeepingById(Model model, @PathVariable Long id, Principal principal) {
        String username = principal.getName();
        UserDTO currentUser = userService.getUserByUsername(username);

        UserDTO userDTO = rollCallAndTimekeepingService.getUserById(id);

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("userDTO", userDTO);
        return "RollCallAndTimekeeping";
    }

    @PostMapping("/roll-call")
    public ResponseEntity<?> rollCall(@RequestBody RollCallAndTimekeepingRequest request) {
        rollCallAndTimekeepingService.rollCall(request);
        return ResponseEntity.ok().body("succ");
    }

    @PostMapping("/timekeeping")
    public ResponseEntity<?> timekeeping(@RequestBody RollCallAndTimekeepingRequest request) {
        rollCallAndTimekeepingService.timekeeping(request);
        return ResponseEntity.ok().body("succ");
    }

}
