package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.Player;
import com.lck_manager.api.lck_manger_rest_api.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
    Season findSeasonBySeasonForShort(String seasonForShort);
    List<Season> findAllBy();
}
