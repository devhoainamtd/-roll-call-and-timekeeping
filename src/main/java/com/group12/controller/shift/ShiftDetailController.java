package com.group12.controller.shift;

import com.group12.dto.ShiftDTO;
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
public class ShiftDetailController {
    @Autowired
    private RollCallAndTimekeepingService rollCallAndTimekeepingService;
    @Autowired
    private UserService userService;
    @GetMapping("/shift-detail/{id}")
    public String getShiftById(Model model, @PathVariable Long id, Principal principal) {
        String username = principal.getName();
        UserDTO currentUser = userService.getUserByUsername(username);
        model.addAttribute("currentUser", currentUser);
        ShiftDTO shiftDTO = rollCallAndTimekeepingService.getShiftById(id);


        model.addAttribute("shiftDTO", shiftDTO);
        return "shiftDetail";
    }
}
