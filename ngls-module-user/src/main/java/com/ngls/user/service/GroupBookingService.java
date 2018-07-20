package com.ngls.user.service;

import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.dto.GroupBookingDto;
import com.ngls.user.session.UserInfo;

import java.util.List;

/**
 * 拼团 Service
 */
public interface GroupBookingService {


    /**
     * 添加一个拼团
     *
     * @return
     */
    ApiResult<GroupBookingDto> addOne(GroupBookingDto groupBookingDto, UserInfo userInfo);


    /**
     * 查询所有拼团
     *
     * @return
     */
    ApiResult<List<GroupBookingDto>> findAll(UserInfo userInfo);


    /**
     * 根据用户 ID 查询拼团
     *
     * @param userInfo
     * @return
     */
    ApiResult<List<GroupBookingDto>> findByUserId(UserInfo userInfo);

}
