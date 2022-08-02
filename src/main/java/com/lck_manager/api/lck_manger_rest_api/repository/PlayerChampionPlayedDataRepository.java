package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.Champion;
import com.lck_manager.api.lck_manger_rest_api.entity.Player;
import com.lck_manager.api.lck_manger_rest_api.entity.PlayerChampionPlayData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerChampionPlayedDataRepository extends JpaRepository<PlayerChampionPlayData, Integer> {
    List<PlayerChampionPlayData> findTop5ByPlayerCodeOrderByWin(Player player);

    PlayerChampionPlayData findAllByPlayerCodeAndChampionCode(Player player, Champion champion);
}
