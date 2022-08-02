package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.NewsAndIssue;
import com.lck_manager.api.lck_manger_rest_api.entity.Player;
import com.lck_manager.api.lck_manger_rest_api.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAllBy();

    Player findAllByPlayerCode(int playerCode);

    List<Player> findAllBySeasonCode(Season season);

    List<Player> findAllByPosition(int position);
}
