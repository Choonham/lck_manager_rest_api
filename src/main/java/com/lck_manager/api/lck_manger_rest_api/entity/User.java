package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCode;

    private String userId;

    private int userPassword;

    private int userLoginType;

    private String userPhoneNum;

    private String userNickName;

    private int userFameLv;

    private int userMoney;

    private int seasonCode;

    private int matchNum;

    private int apiVer;

}

