package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.Champion;
import com.lck_manager.api.lck_manger_rest_api.entity.ChampionCounter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChampionCounterRepository extends JpaRepository<ChampionCounter, Integer> {
    List<ChampionCounter> findChampionCountersByChampion(int championCode);

    ChampionCounter findChampionCounterByChampionAndCounterChampion(int championCode, int counterChampionCode);
}
