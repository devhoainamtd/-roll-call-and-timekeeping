package com.group12.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateShiftRequest {
    private Long shiftId;
    private ShiftDTO shiftDTO;
}
