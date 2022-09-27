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

    @Column(columnDefinition = "default 0")
    private int userType;

    private String teamName;

    @ManyToOne
    @JoinColumn(name="season_code")
    private Season season;

    @Column(columnDefinition = "default 0")
    private double winRate;

    @Column(columnDefinition = "default 0")
    private int totalWins;

    @Column(columnDefinition = "default 0")
    private int totalLoses;

}
