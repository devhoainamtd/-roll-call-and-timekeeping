package com.group12.controller.shift;

import com.group12.dto.RegisterShiftRequest;
import com.group12.dto.ShiftDTO;
import com.group12.dto.UserDTO;
import com.group12.service.RollCallAndTimekeepingService;
import com.group12.service.ShiftService;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@Controller
public class RegisterShiftController {

    @Autowired
    private RollCallAndTimekeepingService rollCallAndTimekeepingService;
    @Autowired
    private ShiftService shiftService;
    @Autowired
    private UserService userService;

    @GetMapping("/page/register-shift")
    public String registerShiftPage(Model model, Principal principal) {
        String username = principal.getName();
        UserDTO currentUser = userService.getUserByUsername(username);
        List<ShiftDTO> listShift = shiftService.getAllShifts();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("listShift", listShift);
        return "RegisterShift";
    }

    @PostMapping("/register-shift")
    public ResponseEntity<?> registerShift(@RequestBody RegisterShiftRequest request) {
        rollCallAndTimekeepingService.registerShift(request);
        return ResponseEntity.ok().body("Successfully!...");
    }

}
