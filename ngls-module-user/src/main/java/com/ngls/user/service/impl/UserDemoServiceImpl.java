package com.ngls.user.service.impl;

import com.ngls.user.dao.UserDemoDao;
import com.ngls.user.domain.UserDemo;
import com.ngls.user.service.UserDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserDemoServiceImpl implements UserDemoService {

    @Autowired
    private UserDemoDao userDemoDao;

    @Override
    public UserDemo find(Long id) {
        return userDemoDao.find(id);
    }

    @Override
    public Long insert(UserDemo userDemo) {
        userDemoDao.insert(userDemo);
        return userDemo.getId();
    }
}
