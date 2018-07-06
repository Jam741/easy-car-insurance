package com.ngls.user.dao;

import com.ngls.user.domain.UserJpaDemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kixs
 * @version 1.0, 2018/6/30
 */
@Repository
public interface UserJpaDemoRepository extends CrudRepository<UserJpaDemo, Long> {
}
