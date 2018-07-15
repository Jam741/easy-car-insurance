package com.ngls.web.customer.controller.company;


import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.domain.Company;
import com.ngls.user.service.impl.CompanyService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService service;

    @GetMapping(value = "/list")
    public ApiResult<List<Company>> companyList() {
        return service.findAll();
    }

    @PostMapping(value = "/company")
    public ApiResult<Company> addOne(@RequestBody Company company) {
        return service.save(company);
    }

    @DeleteMapping(value = "/company")
    public ApiResult deleteById(@ApiParam Long id) {
        return service.delete(id);
    }


    @PutMapping(value = "/company")
    public ApiResult<Company> update(@RequestBody Company company) {
        return service.save(company);
    }

    @GetMapping(value = "/company/{id}")
    public ApiResult<Company> getOne(@PathVariable Long id){
        return service.getOne(id);
    }
}
