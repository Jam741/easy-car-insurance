package com.ngls.user.service.impl;


import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.dao.CompanyRepository;
import com.ngls.user.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyService {

    @Autowired
    CompanyRepository repository;

    public ApiResult<Company> getOne(Long id) {
        return ApiResult.succ(repository.getOne(id));
    }

    public ApiResult<List<Company>> findAll() {
        return ApiResult.succ(repository.findAll());
    }

    public ApiResult<Company> save(Company company) {
        return ApiResult.succ(repository.save(company));
    }

    public ApiResult delete(Long id) {
        repository.deleteById(id);
        return ApiResult.succ();
    }
}
