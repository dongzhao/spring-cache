package com.dzhao.exams.spring.ehcache;

import java.io.Serializable;

/**
 * Created by dzhao on 2/05/2016.
 */
public class MyProduct implements Serializable{

    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
