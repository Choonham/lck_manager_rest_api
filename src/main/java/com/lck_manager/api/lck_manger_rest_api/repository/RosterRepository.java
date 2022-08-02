package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.Roster;
import com.lck_manager.api.lck_manger_rest_api.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RosterRepository extends JpaRepository<Roster, Integer> {
    List<Roster> findAllByTeamAndMainEntry(Team team, int mainEntry);
}