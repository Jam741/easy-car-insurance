package com.ngls.user.dao;

import com.ngls.user.domain.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 管理员信息Repository
 *
 * @author Kixs
 * @version 1.0, 2018/7/4
 */
@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
}
