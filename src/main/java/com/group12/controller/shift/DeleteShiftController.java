package com.group12.controller.shift;

import com.group12.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DeleteShiftController {

    @Autowired
    private ShiftService shiftService;

    @PostMapping("/delete-shift")
    public ResponseEntity<?> deleteShift(@RequestBody Long id) {
        shiftService.deleteShift(id);
        return ResponseEntity.ok().body("Delete Successfully!");
    }
}
