package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.TransferWindow;
import com.lck_manager.api.lck_manger_rest_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserCode(int userCode);
}
