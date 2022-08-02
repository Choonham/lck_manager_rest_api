package com.lck_manager.api.lck_manger_rest_api.repository;

import com.lck_manager.api.lck_manger_rest_api.entity.MatchData;
import com.lck_manager.api.lck_manger_rest_api.entity.NewsAndIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsAndIssueRepository extends JpaRepository<NewsAndIssue, Integer> {
}
