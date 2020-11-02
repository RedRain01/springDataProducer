package com.example.springpublic.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private String naem;
    private  String id;

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
