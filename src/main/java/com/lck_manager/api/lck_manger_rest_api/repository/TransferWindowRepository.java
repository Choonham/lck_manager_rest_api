package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.Team;
import com.lck_manager.api.lck_manger_rest_api.entity.TransferWindow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferWindowRepository extends JpaRepository<TransferWindow, Integer> {
}
