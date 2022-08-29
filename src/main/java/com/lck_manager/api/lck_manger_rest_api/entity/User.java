package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCode;

    private String userId;

    @Nullable
    private String userName;

    @Column(columnDefinition = "default ''")
    private String userPassword;

    @Column(columnDefinition = "default 0")
    private int userLoginType;

    @Column(columnDefinition = "default ''")
    private String userPhoneNum;

    private String userNickName;

    @Column(columnDefinition = "default 0")
    private int userFameLv;

    @Column(columnDefinition = "default 0")
    private int userMoney;

    private int seasonCode;

    @Column(columnDefinition = "default 0")
    private int matchNum;

    @Column(columnDefinition = "default 0")
    private int apiVer;

}

