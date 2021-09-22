package com.example.springgateway.controller.event;

public class Stu {
    private String id;
    private  String name;
    private  String ip;

    public Stu(String id, String name, String ip) {
        this.id = id;
        this.name = name;
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
