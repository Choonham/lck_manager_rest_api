package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.MatchData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchDataRepository extends JpaRepository<MatchData, Integer> {
}
