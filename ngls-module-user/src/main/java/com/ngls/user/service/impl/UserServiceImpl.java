package com.ngls.user.service.impl;

import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.common.util.validation.FieldChecker;
import com.ngls.user.dao.UserRepository;
import com.ngls.user.domain.User;
import com.ngls.user.dto.UserDto;
import com.ngls.user.exception.UserErrorCode;
import com.ngls.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 用户ServiceImpl
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public ApiResult<UserDto> findUserById(Long id) {
        FieldChecker.checkEmpty(id, "id");

        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return ApiResult.fail(UserErrorCode.USER_NOT_EXISTED);
        }

        return ApiResult.succ(new UserDto(optionalUser.get()));
    }
}
