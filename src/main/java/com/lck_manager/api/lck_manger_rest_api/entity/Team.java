package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamCode;

    @ManyToOne
    @JoinColumn(name="user_code")
    private User userCode;

    private int userType;

    private String teamName;

    @ManyToOne
    @JoinColumn(name="season_code")
    private Season season;

    private double winRate;

    private int totalWins;

    private int totalLoses;

}
