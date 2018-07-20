package com.ngls.user.service;


import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.domain.Banner;
import com.ngls.user.dto.BannerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BannerService {

    ApiResult<BannerDto> findOne(Long id);

    ApiResult<BannerDto> save(BannerDto banner);

    ApiResult delete(Long id);

    ApiResult<List<BannerDto>> findAll();
}
