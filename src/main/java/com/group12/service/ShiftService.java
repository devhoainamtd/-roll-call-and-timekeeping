package com.group12.service;

import com.group12.dto.ShiftDTO;
import com.group12.dto.UpdateShiftRequest;
import com.group12.dto.UserDTO;
import com.group12.model.User;

import java.util.List;

public interface ShiftService {
    public ShiftDTO addShift(ShiftDTO shiftDTO);
    public List<ShiftDTO> getAllShifts();
    public ShiftDTO getShiftById(Long id);
    public ShiftDTO updateShift(UpdateShiftRequest request);
    public void deleteShift(Long id);
}
