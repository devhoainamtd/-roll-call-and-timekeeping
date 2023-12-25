package com.group12.controller.shift;

import com.group12.dto.ShiftDTO;
import com.group12.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AddShiftController {

    @Autowired
    private ShiftService shiftService;

    @GetMapping("/add-shift")
    public String addShift() {
        return "AddShift";
    }

    @PostMapping("/add-shift")
    public ResponseEntity<?> addShift(@RequestBody ShiftDTO shiftDTO) {
        shiftService.addShift(shiftDTO);
        return ResponseEntity.ok().body("ok!!!!!!!!!");
    }

}
