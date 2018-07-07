package com.ngls.user.dao;

import com.ngls.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息Repository
 *
 * @author Kixs
 * @version 1.0, 2018/7/4
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByOpenId(String openId);

    public List<User> findByUnionId(String unionId);

}
