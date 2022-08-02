package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="roster")
public class Roster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mainRosterCode;

    @ManyToOne
    @JoinColumn(name="team_code")
    private Team team;

    @ManyToOne
    @JoinColumn(name="player_code")
    private Player player;

    private int mainOrder;

    private int mainEntry;

}
