package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.NewsAndIssue;
import com.lck_manager.api.lck_manger_rest_api.entity.Player;
import com.lck_manager.api.lck_manger_rest_api.entity.Roster;
import com.lck_manager.api.lck_manger_rest_api.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAllBy();

    Player findAllByPlayerCode(int playerCode);

    List<Player> findAllBySeasonCode(Season season);

    List<Player> findAllByPosition(int position);

    @Query(
            value = "SELECT " +
                    "player_code, player_name, position, fame_lv, lane_strength, out_smart, physical, stability, team_fight, season_code " +
                    "FROM player " +
                    "WHERE position = :position " +
                    "AND season_code = :seasonCode " +
                    "ORDER BY RAND() LIMIT 2",
            nativeQuery = true
    )
    List<Player> getFirstPlayerList(@Param("position") int position, @Param("seasonCode") int seasonCode);
}
