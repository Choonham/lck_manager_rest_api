package com.lck_manager.api.lck_manger_rest_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="transfer_window")
public class TransferWindow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transferWindowCode;

    private int weeks;

    @ManyToOne
    @JoinColumn(name="player_code")
    private Player playerCode;

    private int transferFee;

    private int salaryWants;

    private int salaryOffer;

    private int minSalary;

}
