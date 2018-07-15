package com.ngls.user.service.impl;

import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.dao.GroupBookingRepository;
import com.ngls.user.domain.GroupBooking;
import com.ngls.user.dto.GroupBookingDto;
import com.ngls.user.service.GroupBookingService;
import com.ngls.user.session.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class GroupBookingServicelmpl implements GroupBookingService {

    @Autowired
    private GroupBookingRepository repository;

    @Override
    public ApiResult<GroupBookingDto> addOne(GroupBookingDto dto, UserInfo userInfo) {
        GroupBooking groupBooking = new GroupBooking();
        groupBooking.setLicenseNo(dto.getLicenseNo());
        groupBooking.setOwnerName(dto.getOwnerName());
        groupBooking.setOwnerPhone(dto.getOwnerPhone());
        groupBooking.setLastDate(dto.getLastDate());
        groupBooking.setUserId(userInfo.id);
        return ApiResult.succ(new GroupBookingDto(repository.save(groupBooking)));
    }

    @Override
    public ApiResult<List<GroupBookingDto>> findAll(UserInfo userInfo) {
        List<GroupBookingDto> groupBookingDtos = null;
        List<GroupBooking> groupBookings = repository.findAll();
        for (GroupBooking groupBooking : groupBookings) {
            if (groupBookingDtos == null) groupBookingDtos = new ArrayList<>();
            groupBookingDtos.add(new GroupBookingDto(groupBooking));

        }
        return ApiResult.succ(groupBookingDtos);
    }

    @Override
    public ApiResult<List<GroupBookingDto>> findByUserId(UserInfo userInfo) {
        List<GroupBookingDto> groupBookingDtos = null;
        List<GroupBooking> groupBookings = repository.findByUserId(userInfo.id);
        if (groupBookings == null) return ApiResult.succ();
        for (GroupBooking groupBooking : groupBookings) {
            if (groupBookingDtos == null) groupBookingDtos = new ArrayList<>();
            groupBookingDtos.add(new GroupBookingDto(groupBooking));
        }
        return ApiResult.succ(groupBookingDtos);
    }


}
