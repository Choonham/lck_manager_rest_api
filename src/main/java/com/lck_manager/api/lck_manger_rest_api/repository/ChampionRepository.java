package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChampionRepository extends JpaRepository<Champion, Integer> {
    List<Champion> findAllBy();

    Champion findChampionByChampionCode(int championCode);
}
