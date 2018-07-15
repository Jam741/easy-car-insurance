package com.ngls.user.dao;

import com.ngls.user.domain.GroupBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupBookingRepository extends JpaRepository<GroupBooking, Long> {

    List<GroupBooking> findByUserId(Long userId);

}
