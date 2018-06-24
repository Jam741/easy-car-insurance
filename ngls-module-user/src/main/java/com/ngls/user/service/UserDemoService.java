package com.ngls.user.service;

import com.ngls.user.domain.UserDemo;

public interface UserDemoService {

    UserDemo find(Long id);

    Long insert(UserDemo userDemo);
}
