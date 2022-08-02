package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="pog_point_rank")
public class PogPointRank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pogRankCode;

    private int rank;

    @ManyToOne
    @JoinColumn(name="player_code")
    private Player playerCode;

    private int pogPoint;

}
