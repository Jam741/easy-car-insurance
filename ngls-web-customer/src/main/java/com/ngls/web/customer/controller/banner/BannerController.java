package com.ngls.web.customer.controller.banner;


import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.dto.BannerDto;
import com.ngls.user.service.BannerService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {


    @Autowired
    BannerService bannerService;

    @GetMapping(name = "/list")
    public ApiResult<List<BannerDto>> listBanner() {
        return bannerService.findAll();
    }


    @PostMapping(name = "/banner")
    public ApiResult<BannerDto> save(@RequestBody BannerDto bannerDto) {
        return bannerService.save(bannerDto);
    }

    @GetMapping(name = "/banner/{id}")
    public ApiResult<BannerDto> findOne(@PathVariable Long id) {
        return bannerService.findOne(id);
    }

    @DeleteMapping(name = "/banner")
    public ApiResult delete(@ApiParam Long id) {
        return bannerService.delete(id);
    }

}
