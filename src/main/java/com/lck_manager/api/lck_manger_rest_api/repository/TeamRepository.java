package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.Season;
import com.lck_manager.api.lck_manger_rest_api.entity.Team;
import com.lck_manager.api.lck_manger_rest_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team findAllByTeamCode(int teamCode);

    List<Team> findAllBySeason(Season season);

    @Query("SELECT t FROM Team t WHERE t.season = :season and (t.userCode = :userCode or t.userCode = :userCode2)")
    List<Team> findAllBySeasonAndAdminOrUserCode(Season season, User userCode, User userCode2);
}
