package com.ngls.web.customer.controller.groupbooking;


import com.ngls.common.util.mvc.resolver.FromSession;
import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.dto.GroupBookingDto;
import com.ngls.user.service.GroupBookingService;
import com.ngls.user.session.UserInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupBookingController {

    @Autowired
    GroupBookingService groupBookingService;

    @ApiOperation(value = "添加一个拼团", notes = "微信登录")
    @PostMapping(value = "/groupBooking")
    public ApiResult<GroupBookingDto> addOne(
            @ApiParam(name = "groupBookingDto", value = "拼团对象")
            @RequestBody GroupBookingDto groupBookingDto, @FromSession UserInfo userInfo) {
        return groupBookingService.addOne(groupBookingDto, userInfo);
    }


    @GetMapping(value = "/groupBooking/list")
    public ApiResult<List<GroupBookingDto>> findByUserId(@FromSession UserInfo userInfo) {
        return groupBookingService.findByUserId(userInfo);
    }

}
