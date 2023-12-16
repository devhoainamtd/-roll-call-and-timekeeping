package com.group12.controller;

import java.security.Principal;
import java.util.List;

import com.group12.dto.UserDTO;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.group12.dto.ShiftDTO;
import com.group12.service.ShiftService;

@Controller
public class ShowAllShiftController {
    @Autowired
    private ShiftService shiftService;
    @Autowired
    private UserService userService;

    @GetMapping("/show-all-shift")
    public String getAllShifts(Model model, Principal principal) {
        String username = principal.getName();
        UserDTO currentUser = userService.getUserByUsername(username);
        model.addAttribute("currentUser", currentUser);

        List<ShiftDTO> listShift = shiftService.getAllShifts();
        model.addAttribute("listShift", listShift);
        return "showAllShift";
    }
}
