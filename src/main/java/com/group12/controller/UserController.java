package com.group12.controller;

import com.group12.dto.*;
import com.group12.service.RollCallAndTimekeepingService;
import com.group12.service.ShiftService;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ShiftService shiftService;
    @Autowired
    private RollCallAndTimekeepingService rollCallTimekeepingService;

//    User
    @PostMapping("/add-user")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.addUser(userDTO));
    }
    @GetMapping("/get-all-users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return rollCallTimekeepingService.getUserById(id);
    }

    @PostMapping("/update-user/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
    return null;
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("Delete user successfully!");
    }

//    Shift
    @PostMapping("/add-shift")
    public ResponseEntity<ShiftDTO> addShift(@RequestBody ShiftDTO shiftDTO) {
        return ResponseEntity.ok().body(shiftService.addShift(shiftDTO));
    }

    @GetMapping("/get-all-shifts")
    public List<ShiftDTO> getAllShifts() {
        return shiftService.getAllShifts();
    }

    @PostMapping("/update-shift/{id}")
    public ShiftDTO updateShift(@PathVariable Long id, @RequestBody ShiftDTO shiftDTO) {
        return shiftService.updateShift(id, shiftDTO);
    }

    @DeleteMapping("/delete-shift/{id}")
    public ResponseEntity<?> deleteShift(@PathVariable Long id) {
        shiftService.deleteShift(id);
        return ResponseEntity.ok().body("Delete Shift Successfully !");
    }

    @PostMapping("/register-shift")
    public ResponseEntity<String> registerShift(@RequestBody Request request) {
        rollCallTimekeepingService.registerShift(request);
        return ResponseEntity.ok().body("Register Shift sucessfull!!!");
    }

    @PostMapping("/roll-call")
    public ResponseEntity<RollCallAndTimekeepingDTO> rollCall(@RequestBody RollCallAndTimekeepingRequest request) {
        return ResponseEntity.ok().body(rollCallTimekeepingService.rollCall(request));
    }
}
