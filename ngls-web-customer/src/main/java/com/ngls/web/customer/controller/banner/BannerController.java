package com.ngls.web.customer.controller.banner;


import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.dto.BannerDto;
import com.ngls.user.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {


    @Autowired
    BannerService bannerService;

    @GetMapping
    public ApiResult<List<BannerDto>> listBanner() {
        return bannerService.findAll();
    }


    @PostMapping
    public ApiResult<BannerDto> save(@RequestBody BannerDto bannerDto) {
        return bannerService.save(bannerDto);
    }

    @GetMapping("{id}")
    public ApiResult<BannerDto> findOne(@PathVariable(name = "id") Long id) {
        return bannerService.findOne(id);
    }

    @DeleteMapping
    public ApiResult delete(@RequestParam("id") Long id) {
        return bannerService.delete(id);
    }

}
