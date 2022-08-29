package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="champion")
@Data
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int championCode;

    private String championName;

    private int laneStrength;

    private int teamFight;

    private int splitPush;

    private int initiating;

    private int poking;

    private int nuking;

    private int util;

    private int cc;

    private int gank;

    private int tank;

    private int dps;

    private double potential1;

    private double potential2;

    private double potential3;

    @Nullable
    private int type;

    @Nullable
    private double winRate;

}
