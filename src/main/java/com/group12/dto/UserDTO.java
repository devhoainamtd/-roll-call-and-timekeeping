package com.group12.dto;

import com.group12.model.RollCallAndTimekeeping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String image;
    private String username;
    private String password;
    private Integer seniority;
    private String email;
    private Long phoneNumber;
    private Long accountNumber;
    private String address;
    private String position;
    private String salary;
    private List<RollCallAndTimekeepingDTO> rollCallAndTimekeepingDTOList ;

}
