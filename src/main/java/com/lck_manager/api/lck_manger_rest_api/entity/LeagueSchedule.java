package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="league_schedule")
public class LeagueSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leagueScheduleCode;

    @Temporal(TemporalType.DATE)
    private Date date;

    private int matchNum;

    @ManyToOne
    @JoinColumn(name="team_code_a")
    private Team teamA;

    @ManyToOne
    @JoinColumn(name="team_code_b")
    private Team teamB;

    private String teamAName;

    private String teamBName;

    private int scoreA = 0;

    private int scoreB = 0;

    private int playFlag;

}
