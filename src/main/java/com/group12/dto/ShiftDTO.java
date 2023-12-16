package com.group12.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftDTO {
    private Long id;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private Date workingDay;
    private Integer max;
    private List<RollCallAndTimekeepingDTO> rollCallAndTimekeepingDTOList ;

}
