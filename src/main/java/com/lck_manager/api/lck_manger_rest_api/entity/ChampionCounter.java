package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ChampionCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int championCounterCode;

    @ManyToOne
    @JoinColumn(name="champion_code")
    private Champion champion;

    @ManyToOne
    @JoinColumn(name="counter_champion_code")
    private Champion counterChampion;

    private int laneWinRate;
}
