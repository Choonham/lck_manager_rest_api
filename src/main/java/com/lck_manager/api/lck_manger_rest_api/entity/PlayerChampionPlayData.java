package com.lck_manager.api.lck_manger_rest_api.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="player_champion_play_data")
public class PlayerChampionPlayData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerPlayDataCode;

    @ManyToOne
    @JoinColumn(name="player_code")
    private Player playerCode;

    @ManyToOne
    @JoinColumn(name="champion_code")
    private Champion championCode;

    private int win;

    private int lose;

    private double kda;

}
