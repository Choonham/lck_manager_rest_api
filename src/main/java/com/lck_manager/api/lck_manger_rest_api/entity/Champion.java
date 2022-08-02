package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="champion")
@Data
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int championCode;

    private String championName;

    private double laneStrength;

    private double teamFight;

    private double splitPush;

    private double oneVsOneStrength;

    private double initiating;

    private double poking;

    private int type;

    private double toSixPotential;

    private double toElvPotential;

    private double toSixteenPotential;

}
