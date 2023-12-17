package com.group12.service.impl;

import com.group12.dto.ShiftDTO;
import com.group12.dto.UpdateShiftRequest;
import com.group12.model.Shift;
import com.group12.repository.ShiftRepository;
import com.group12.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    public ShiftRepository shiftRepository;
    @Override
    public ShiftDTO addShift(ShiftDTO shiftDTO) {
        return mapToDTO(shiftRepository.save(mapToEntity(shiftDTO)));
    }

    @Override
    public List<ShiftDTO> getAllShifts() {
        List<ShiftDTO> dtoList = new ArrayList<>();
        for (Shift s : shiftRepository.findAll()) {
            dtoList.add(mapToDTO(s));
        }
        return dtoList;
    }

    @Override
    public ShiftDTO getShiftById(Long id) {
        return null;
    }

    @Override
    public ShiftDTO updateShift(UpdateShiftRequest request) {

        Shift shift = shiftRepository.findById(request.getShiftId()).get();

        shift.setName(request.getShiftDTO().getName());
        shift.setStartTime(request.getShiftDTO().getStartTime());
        shift.setEndTime(request.getShiftDTO().getEndTime());
        shift.setWorkingDay(request.getShiftDTO().getWorkingDay());
        shift.setMax(request.getShiftDTO().getMax());
        return mapToDTO(shiftRepository.save(shift));
    }

    @Override
    public void deleteShift(Long id) {
        shiftRepository.deleteById(id);
    }

    public Shift mapToEntity(ShiftDTO shiftDTO) {
        Shift shift = new Shift();
        shift.setName(shiftDTO.getName());
        shift.setStartTime(shiftDTO.getStartTime());
        shift.setEndTime(shiftDTO.getEndTime());
        shift.setWorkingDay(shiftDTO.getWorkingDay());
        shift.setMax(shiftDTO.getMax());
        return shift;
    }

    public ShiftDTO mapToDTO(Shift shift) {
        ShiftDTO shiftDTO = new ShiftDTO();
        shiftDTO.setId(shift.getId());
        shiftDTO.setName(shift.getName());
        shiftDTO.setStartTime(shift.getStartTime());
        shiftDTO.setEndTime(shift.getEndTime());
        shiftDTO.setWorkingDay(shift.getWorkingDay());
        shiftDTO.setMax(shift.getMax());
        return shiftDTO;
    }
}
