package com.group12.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RollCallAndTimekeeping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime rollCallTime;
    private Boolean rollCallStatus;
    private LocalTime timekeepingTime;
    private Boolean timeKeepingStatus;

    @ManyToOne
    @JoinColumn(name = "user_id") // thông qua khóa ngoại address_id
    private User user;

    @ManyToOne
    @JoinColumn(name = "shift_id") // thông qua khóa ngoại address_id
    private Shift shift;
}
