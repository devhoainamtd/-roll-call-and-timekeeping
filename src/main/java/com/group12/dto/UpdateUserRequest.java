package com.group12.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private Long userId;
    private UserDTO userDTO;
}
