package com.ani.testing.domain;

//import java.util.ArrayList;
//import java.util.List;
//
//public class Car {
//
//    private int speed;
//    private boolean isFwd;
//    private List<String> parts = new ArrayList<>();
//
//    public int getSpeed() {
//        return speed;
//    }
//
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
//
//    public boolean isFwd() {
//        return isFwd;
//    }
//
//    public void setFwd(boolean fwd) {
//        isFwd = fwd;
//    }
//
//    public List<String> getParts() {
//        return parts;
//    }
//
//    public void setParts(List<String> parts) {
//        this.parts = parts;
//    }
//}

import java.sql.Date;

public class Car {
    private Long id;
    private String model;
    private Double cost;
    private Date mfg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getMfg() {
        return mfg;
    }

    public void setMfg(Date mfg) {
        this.mfg = mfg;
    }
}