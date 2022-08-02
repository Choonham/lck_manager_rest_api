package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="match_data")
public class MatchData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchDataCode;

    @ManyToOne
    @JoinColumn(name="league_schedule_code")
    private LeagueSchedule leagueScheduleCode;

    @ManyToOne
    @JoinColumn(name="team_code")
    private Team teamCode;

    @ManyToOne
    @JoinColumn(name="player_code")
    private Player playerCode;

    @ManyToOne
    @JoinColumn(name="champion_code")
    private Champion championCode;

    private double kda;

}
