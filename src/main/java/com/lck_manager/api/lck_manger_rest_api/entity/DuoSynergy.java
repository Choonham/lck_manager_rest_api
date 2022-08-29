package com.lck_manager.api.lck_manger_rest_api.entity;

import com.lck_manager.api.lck_manger_rest_api.enums.DuoEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="DuoSynergy")
@Data
public class DuoSynergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int duoSynergyCode;

    private int firstChampionCode;

    private int secondChampionCode;

    private int rank;

    private double winRate;

    private double synergyPoint;

    private double pickRate;

    private double banRate;

    private int played;

    @Enumerated(EnumType.STRING)
    private DuoEnum type;

}
