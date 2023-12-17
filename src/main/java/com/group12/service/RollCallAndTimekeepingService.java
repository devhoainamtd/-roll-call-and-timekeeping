package com.group12.service;

import com.group12.dto.*;

public interface RollCallAndTimekeepingService {
    public void registerShift(RegisterShiftRequest registerShiftRequest);
    public UserDTO getUserById(Long id);
    public ShiftDTO getShiftById(Long id);
    public void deleteRollCallAndTimekeepingById(Long id);
    public RollCallAndTimekeepingDTO getRollCallAndTimeKeepingById(Long id);
    public RollCallAndTimekeepingDTO rollCall(RollCallAndTimekeepingRequest request);
    public RollCallAndTimekeepingDTO timekeeping(RollCallAndTimekeepingRequest request);

}
