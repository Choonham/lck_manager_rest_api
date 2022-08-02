package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="league_season_team")
public class LeagueSeasonTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leagueSeasonTeamCode;

    @ManyToOne
    @JoinColumn(name="season_code")
    private Season seasonCode;

    private int leagueId;

    @ManyToOne
    @JoinColumn(name="team_code")
    private Team team;

    private int win;

    private int lose;

    private int wd;

}
