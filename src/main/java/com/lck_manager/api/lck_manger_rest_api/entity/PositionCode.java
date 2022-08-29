package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class PositionCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionCode;

    private String positionName;
}
