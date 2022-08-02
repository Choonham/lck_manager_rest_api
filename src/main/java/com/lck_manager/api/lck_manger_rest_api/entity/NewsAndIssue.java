package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="news_and_issue")
public class NewsAndIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsCode;

    @ManyToOne
    @JoinColumn(name="team_code")
    private Team teamCode;

    private String newsTitle;

    private String newsContent;

    @ManyToOne
    @JoinColumn(name="effected_player")
    private Player effectedPlayer;

    @ManyToOne
    @JoinColumn(name="effect_first_code")
    private NewsEffects effectFirstCode;

    @ManyToOne
    @JoinColumn(name="effect_second_code")
    private NewsEffects effectSecondCode;

    @ManyToOne
    @JoinColumn(name="effect_third_code")
    private NewsEffects effectThirdCode;

    private int effectRemain;
}
