package com.group12.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RollCallAndTimekeepingDTO {
    private Long id;
    private LocalTime rollCallTime;
    private Boolean rollCallStatus;
    private LocalTime timekeepingTime;
    private Boolean timekeepingStatus;
    private UserDTO userDTO;
    private ShiftDTO shiftDTO;
}
