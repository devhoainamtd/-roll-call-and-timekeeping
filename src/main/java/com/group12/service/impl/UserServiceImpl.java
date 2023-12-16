package com.group12.service.impl;

import com.group12.dto.RollCallAndTimekeepingDTO;
import com.group12.dto.ShiftDTO;
import com.group12.dto.UpdateUserRequest;
import com.group12.dto.UserDTO;
import com.group12.model.RollCallAndTimekeeping;
import com.group12.model.Shift;
import com.group12.model.User;
import com.group12.repository.UserRepository;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        return mapToDTO(userRepository.save(mapToEntity(userDTO)));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> dtoList = new ArrayList<>();
        for (User u : userRepository.findAll()) {
            dtoList.add(mapToDTO(u));
        }
        return dtoList;
    }

    @Override
    public UserDTO getUserById(Long id) {
//        User user = userRepository.findById(id).get();
        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setImage(user.getImage());
//        userDTO.setSeniority(user.getSeniority());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPhoneNumber(user.getPhoneNumber());
//        userDTO.setAccountNumber(user.getAccountNumber());
//        userDTO.setAddress(user.getAddress());
//        userDTO.setPosition(user.getPosition());
//        userDTO.setSalary(user.getSalary());
//        List<RollCallAndTimekeepingDTO> list = new ArrayList<>();
//        for (RollCallAndTimekeeping l : user.getRollCallAndTimekeepingList()) {
//            RollCallAndTimekeepingDTO rollCallAndTimekeepingDTO = new RollCallAndTimekeepingDTO();
//            rollCallAndTimekeepingDTO.setId(l.getId());
//            rollCallAndTimekeepingDTO.setTimekeepingTime(l.getTimekeepingTime());
//            rollCallAndTimekeepingDTO.setRollCallStatus(l.getRollCallStatus());
//            rollCallAndTimekeepingDTO.setRollCallTime(l.getRollCallTime());
//            rollCallAndTimekeepingDTO.setUserDTO(mapToDTO(l.getUser()));
//            rollCallAndTimekeepingDTO.setShiftDTO();
//
//        }
//        userDTO.setRollCallAndTimekeepingDTOList(user.getRollCallAndTimekeepingList());
        return userDTO;
    }

    @Override
    public UserDTO updateUser(UpdateUserRequest request) {
        User user = userRepository.findById(request.getUserId()).get();

        user.setName(request.getUserDTO().getName());
        user.setImage(userDTO.getImage());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setSeniority(userDTO.getSeniority());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAccountNumber(userDTO.getAccountNumber());
        user.setAddress(userDTO.getAddress());
        user.setPosition(userDTO.getPosition());
        user.setSalary(userDTO.getSalary());

        return mapToDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return mapToDTO(userRepository.findByUsername(username));
    }

    public User mapToEntity(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setImage(userDTO.getImage());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setSeniority(userDTO.getSeniority());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAccountNumber(userDTO.getAccountNumber());
        user.setAddress(userDTO.getAddress());
        user.setPosition(userDTO.getPosition());
        user.setSalary(userDTO.getSalary());

        return user;
    }

    public UserDTO mapToDTO(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setImage(user.getImage());
        userDTO.setSeniority(user.getSeniority());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setAccountNumber(user.getAccountNumber());
        userDTO.setAddress(user.getAddress());
        userDTO.setPosition(user.getPosition());
        userDTO.setSalary(user.getSalary());

        return userDTO;
    }
}
