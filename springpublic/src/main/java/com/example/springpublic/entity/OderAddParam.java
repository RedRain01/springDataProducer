package com.example.springpublic.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：why
 * @description：TODO
 * @date ：2020/3/21 11:29
 */

@Data
public class OderAddParam implements Serializable {
    private String cargoNum;
    private String userCode;
    private String phone;
    private int quantity;
    private double price;
    private String partitionNum;

}
