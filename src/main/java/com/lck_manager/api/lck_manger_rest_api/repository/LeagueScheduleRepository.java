package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.LeagueSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeagueScheduleRepository extends JpaRepository<LeagueSchedule, Integer> {
    List<LeagueSchedule> findAllByOrderByMatchNumDesc();

}
