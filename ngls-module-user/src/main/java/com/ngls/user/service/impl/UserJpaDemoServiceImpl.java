package com.ngls.user.service.impl;

import com.ngls.user.dao.UserJpaDemoRepository;
import com.ngls.user.domain.UserJpaDemo;
import com.ngls.user.service.UserJpaDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @author Kixs
 * @version 1.0, 2018/6/30
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class UserJpaDemoServiceImpl implements UserJpaDemoService {

    @Resource
    private UserJpaDemoRepository userJpaDemoRepository;

    @Override
    public UserJpaDemo find(Long id) {
        return userJpaDemoRepository.findById(id).get();
    }

    @Override
    public Long insert(UserJpaDemo userDemo) {
        userJpaDemoRepository.save(userDemo);
        return userDemo.getId();
    }
}
