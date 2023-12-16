package com.group12.service;

import com.group12.dto.UpdateUserRequest;
import com.group12.dto.UserDTO;
import com.group12.model.User;

import java.util.List;

public interface UserService {

    public UserDTO addUser(UserDTO userDTO);
    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(Long id);
    public UserDTO updateUser(UpdateUserRequest request);
    public void deleteUser(Long id);
    public UserDTO getUserByUsername(String username);
}
