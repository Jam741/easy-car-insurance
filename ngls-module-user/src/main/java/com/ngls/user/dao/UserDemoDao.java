package com.ngls.user.dao;

import com.ngls.user.domain.UserDemo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDemoDao {

    UserDemo find(@Param("id") Long id);

    void insert(@Param("userDemo") UserDemo userDemo);
}
