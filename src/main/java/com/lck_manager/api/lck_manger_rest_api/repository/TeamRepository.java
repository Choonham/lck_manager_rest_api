package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.Season;
import com.lck_manager.api.lck_manger_rest_api.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team findAllByTeamCode(int teamCode);

    List<Team> findAllBySeason(Season season);
}
