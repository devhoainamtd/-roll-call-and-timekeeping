package com.group12.controller.shift;

import com.group12.dto.ShiftDTO;
import com.group12.dto.UpdateShiftRequest;
import com.group12.dto.UpdateUserRequest;
import com.group12.dto.UserDTO;
import com.group12.service.RollCallAndTimekeepingService;
import com.group12.service.ShiftService;
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
public class UpdateShiftController {
    @Autowired
    private UserService userService;
    @Autowired
    private ShiftService shiftService;
    @Autowired
    private RollCallAndTimekeepingService rollCallAndTimekeepingService;

    @GetMapping("/update-shift/{id}")
    public String updateUser(Model model, @PathVariable Long id, Principal principal) {
        String username = principal.getName();
        UserDTO x = userService.getUserByUsername(username);
        UserDTO currentUser = rollCallAndTimekeepingService.getUserById(x.getId());

        model.addAttribute("currentUser", currentUser);
        return "UpdateShift";
    }
    @PostMapping("/update-shift/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UpdateShiftRequest request) {
        shiftService.updateShift(request);
        return ResponseEntity.ok().body("Succeess!");
    }
}
