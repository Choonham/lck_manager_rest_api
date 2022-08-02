package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerCode;

    @ManyToOne
    @JoinColumn(name="season_code")
    private Season seasonCode;

    private String playerName;

    private int position;

    private double physical;

    private double teamFight;

    private double outSmart;

    private double laneStrength;

    private double stability;

    private int fameLv;

}
