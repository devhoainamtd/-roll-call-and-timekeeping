package com.group12.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "shifts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private Date workingDay;
    private Integer max;

    @OneToMany(mappedBy = "shift", cascade = CascadeType.ALL)
    private List<RollCallAndTimekeeping> rollCallAndTimekeepingList;
}
