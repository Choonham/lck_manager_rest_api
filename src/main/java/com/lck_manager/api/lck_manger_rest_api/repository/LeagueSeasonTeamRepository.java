package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.LeagueSeasonTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeagueSeasonTeamRepository extends JpaRepository<LeagueSeasonTeam, Integer> {

}
