package com.ngls.user.service;

import com.ngls.user.domain.UserJpaDemo;

/**
 * @author Kixs
 * @version 1.0, 2018/6/30
 */
public interface UserJpaDemoService {

    UserJpaDemo find(Long id);

    Long insert(UserJpaDemo userDemo);
}
