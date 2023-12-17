package com.group12.service.impl;

import com.group12.dto.*;
import com.group12.model.RollCallAndTimekeeping;
import com.group12.model.Shift;
import com.group12.model.User;
import com.group12.repository.RollCallAndTimekeepingRepository;
import com.group12.repository.ShiftRepository;
import com.group12.repository.UserRepository;
import com.group12.service.RollCallAndTimekeepingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RollCallAndTimekeepingServiceImpl implements RollCallAndTimekeepingService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShiftRepository shiftRepository;
    @Autowired
    private RollCallAndTimekeepingRepository rollCallTimekeepingRepository;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ShiftServiceImpl shiftService;

//    Đăng ký ca làm việc
    @Override
    public void registerShift(RegisterShiftRequest registerShiftRequest) {
        User user = userRepository.findById(registerShiftRequest.getUserId()).get();
        List<RollCallAndTimekeeping> listOfUser = user.getRollCallAndTimekeepingList();
        List<Shift> shiftList = new ArrayList<>();
        for (Long i : registerShiftRequest.getShiftIds()) {
            shiftList.add(shiftRepository.findById(i).get());
        }

        for(Shift shift : shiftList) {
            int i = 0;
            for (RollCallAndTimekeeping r : listOfUser) {
                if (shift.getId() == r.getShift().getId()) {
                    i = 1;
                    break;
                }
            }
            if (i == 0) {
                RollCallAndTimekeeping rollCallTimekeeping = new RollCallAndTimekeeping();
                rollCallTimekeeping.setUser(user);
                rollCallTimekeeping.setShift(shift);
                rollCallTimekeepingRepository.save(rollCallTimekeeping);
            }
        }

        List<RollCallAndTimekeeping> rollCallTimekeepings = new ArrayList<>();

        for (RollCallAndTimekeeping r : rollCallTimekeepingRepository.findAll()) {
            if (r.getUser().getId() == registerShiftRequest.getUserId()) {
                rollCallTimekeepings.add(r);
            }
        }

        for (Shift s : shiftList) {
            for (RollCallAndTimekeeping r : rollCallTimekeepingRepository.findAll()) {
                if (r.getUser().getId() == registerShiftRequest.getUserId() && r.getShift().getId() == s.getId()) {
                    s.getRollCallAndTimekeepingList().add(r);

                }
            }
        }

        user.setRollCallAndTimekeepingList(rollCallTimekeepings);
    }

//Lấy thông tin người dùng thông qua id
    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).get();
        UserDTO userDTO = new UserDTO();
        userDTO = userService.mapToDTO(user);
        List<RollCallAndTimekeepingDTO> rollCallAndTimekeepingDTOList = new ArrayList<>();
        for (RollCallAndTimekeeping r : user.getRollCallAndTimekeepingList()) {
            RollCallAndTimekeepingDTO rollCallAndTimekeepingDTO = new RollCallAndTimekeepingDTO();
            rollCallAndTimekeepingDTO = mapToDTO(r);
            rollCallAndTimekeepingDTOList.add(rollCallAndTimekeepingDTO);
        }
        userDTO.setRollCallAndTimekeepingDTOList(rollCallAndTimekeepingDTOList);
        return userDTO;
    }

//    Lấy thông tin ca làm việc thông qua id
    @Override
    public ShiftDTO getShiftById(Long id) {
        Shift shift = shiftRepository.findById(id).get();
        ShiftDTO shiftDTO = new ShiftDTO();
        shiftDTO = shiftService.mapToDTO(shift);
        List<RollCallAndTimekeepingDTO> rollCallAndTimekeepingDTOList = new ArrayList<>();
        for (RollCallAndTimekeeping r : shift.getRollCallAndTimekeepingList()) {
            RollCallAndTimekeepingDTO rollCallAndTimekeepingDTO = new RollCallAndTimekeepingDTO();
            rollCallAndTimekeepingDTO = mapToDTO(r);
            rollCallAndTimekeepingDTOList.add(rollCallAndTimekeepingDTO);
        }
        shiftDTO.setRollCallAndTimekeepingDTOList(rollCallAndTimekeepingDTOList);
        return shiftDTO;
    }

    @Override
    public void deleteRollCallAndTimekeepingById(Long id) {
        rollCallTimekeepingRepository.deleteById(id);
    }

    @Override
    public RollCallAndTimekeepingDTO getRollCallAndTimeKeepingById(Long id) {
        RollCallAndTimekeepingDTO rollCallAndTimekeepingDTO = mapToDTO(rollCallTimekeepingRepository.findById(id).get());
        return rollCallAndTimekeepingDTO;
    }

    @Override
    public RollCallAndTimekeepingDTO rollCall(RollCallAndTimekeepingRequest request) {
        User user = userRepository.findById(request.getUserId()).get();
        RollCallAndTimekeeping rollCallAndTimekeeping = new RollCallAndTimekeeping();
        for (RollCallAndTimekeeping r : user.getRollCallAndTimekeepingList()) {
            if (r.getShift().getId() == request.getShiftId()) {
                r.setRollCallTime(request.getCurrentTime());
                r.setRollCallStatus(true);
                rollCallTimekeepingRepository.save(r);
                rollCallAndTimekeeping = r;
            }
        }
        return mapToDTO(rollCallAndTimekeeping);
    }

    @Override
    public RollCallAndTimekeepingDTO timekeeping(RollCallAndTimekeepingRequest request) {
        User user = userRepository.findById(request.getUserId()).get();
        RollCallAndTimekeeping rollCallAndTimekeeping = new RollCallAndTimekeeping();
        for (RollCallAndTimekeeping r : user.getRollCallAndTimekeepingList()) {
            if (r.getShift().getId() == request.getShiftId()) {
                r.setTimekeepingTime(request.getCurrentTime());
                r.setTimeKeepingStatus(true);
                rollCallTimekeepingRepository.save(r);
                rollCallAndTimekeeping = r;
            }
        }
        return mapToDTO(rollCallAndTimekeeping);
    }

//    map data
    public RollCallAndTimekeepingDTO mapToDTO(RollCallAndTimekeeping rollCallAndTimekeeping) {
        RollCallAndTimekeepingDTO rollCallAndTimekeepingDTO = new RollCallAndTimekeepingDTO();
        rollCallAndTimekeepingDTO.setId(rollCallAndTimekeeping.getId());
        rollCallAndTimekeepingDTO.setRollCallTime(rollCallAndTimekeeping.getRollCallTime());
        rollCallAndTimekeepingDTO.setTimekeepingStatus(rollCallAndTimekeeping.getTimeKeepingStatus());
        rollCallAndTimekeepingDTO.setTimekeepingTime(rollCallAndTimekeeping.getTimekeepingTime());
        rollCallAndTimekeepingDTO.setRollCallStatus(rollCallAndTimekeeping.getRollCallStatus());
        rollCallAndTimekeepingDTO.setShiftDTO(shiftService.mapToDTO(rollCallAndTimekeeping.getShift()));
        rollCallAndTimekeepingDTO.setUserDTO(userService.mapToDTO(rollCallAndTimekeeping.getUser()));
        return rollCallAndTimekeepingDTO;
    }
    public RollCallAndTimekeeping mapToEntity(RollCallAndTimekeepingDTO rollCallAndTimekeepingDTO) {
        RollCallAndTimekeeping rollCallAndTimekeeping = new RollCallAndTimekeeping();
        rollCallAndTimekeeping.setId(rollCallAndTimekeepingDTO.getId());
        rollCallAndTimekeeping.setRollCallTime(rollCallAndTimekeepingDTO.getRollCallTime());
        rollCallAndTimekeeping.setTimeKeepingStatus(rollCallAndTimekeepingDTO.getTimekeepingStatus());
        rollCallAndTimekeeping.setTimekeepingTime(rollCallAndTimekeepingDTO.getTimekeepingTime());
        rollCallAndTimekeeping.setRollCallStatus(rollCallAndTimekeepingDTO.getRollCallStatus());
        rollCallAndTimekeeping.setShift(shiftService.mapToEntity(rollCallAndTimekeepingDTO.getShiftDTO()));
        rollCallAndTimekeeping.setUser(userService.mapToEntity(rollCallAndTimekeepingDTO.getUserDTO()));
        return rollCallAndTimekeeping;
    }
}
