package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="news_effects")
public class NewsEffects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int effectCode;

    private int effect;

    private String effectContent;

    private int effectedStatus;

    private int effectedIndex;

}
