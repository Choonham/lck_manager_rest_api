package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PogPointRankRepository extends JpaRepository<Player, Integer> {
}
