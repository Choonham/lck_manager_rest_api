package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.Roster;
import com.lck_manager.api.lck_manger_rest_api.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RosterRepository extends JpaRepository<Roster, Integer> {
    List<Roster> findAllByTeamAndMainEntry(Team team, int mainEntry);

    @Query("SELECT r FROM Roster r LEFT JOIN Team t ON t.teamCode = r.team.teamCode WHERE t.season.seasonCode = :seasonCode")
    List<Roster> findRosterByTeamSeasonCode(int seasonCode);

}