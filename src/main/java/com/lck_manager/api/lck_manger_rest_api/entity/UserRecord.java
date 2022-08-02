package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user_record")
public class UserRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRecordCode;

    @ManyToOne
    @JoinColumn(name="user_code")
    private User userCode;

    @ManyToOne
    @JoinColumn(name="season_code")
    private Season seasonCode;

    private int rank;

    private int win;

    private int lose;

    private int winDiff;

    private int fameDiff;

    private int topPlayerCode;

    private int junglePlayerCode;

    private int midPlayerCode;

    private int adPlayerCode;

    private int supportPlayerCode;
}
