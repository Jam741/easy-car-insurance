package com.ngls.user.service.impl;

import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.common.util.validation.FieldChecker;
import com.ngls.user.dao.BannerRepository;
import com.ngls.user.domain.Banner;
import com.ngls.user.dto.BannerDto;
import com.ngls.user.exception.UserErrorCode;
import com.ngls.user.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(rollbackFor = Exception.class)
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerRepository repository;

    @Override
    public ApiResult<BannerDto> findOne(Long id) {
        FieldChecker.checkEmpty(id, "id");
        Optional<Banner> optionalBanner = repository.findById(id);
        if (!optionalBanner.isPresent()) {
            return ApiResult.fail(UserErrorCode.USER_NOT_EXISTED);
        }
        return ApiResult.succ(new BannerDto(optionalBanner.get()));
    }

    @Override
    public ApiResult<BannerDto> save(BannerDto bannerDto) {
        FieldChecker.checkEmpty(bannerDto, "id");
        Banner banner = new Banner();
        if (bannerDto.id != null)
            banner.id = bannerDto.id;
        banner.setImg(bannerDto.getImg());
        banner.setAction(bannerDto.getAction());
        return ApiResult.succ(new BannerDto(repository.save(banner)));
    }

    @Override
    public ApiResult delete(Long id) {
        FieldChecker.checkEmpty(id, "id");
        repository.deleteById(id);
        return ApiResult.succ();
    }


    @Override
    public ApiResult<List<BannerDto>> findAll() {
        List<BannerDto> bannerDtoList = null;
        List<Banner> bannerList = repository.findAll();
        if (bannerDtoList == null) return ApiResult.succ();
        for (Banner banner : bannerList) {
            bannerDtoList.add(new BannerDto(banner));
        }
        return ApiResult.succ(bannerDtoList);
    }
}
