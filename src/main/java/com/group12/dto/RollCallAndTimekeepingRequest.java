package com.group12.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RollCallAndTimekeepingRequest {
    private Long userId;
    private Long shiftId;
    private LocalTime currentTime;
}
