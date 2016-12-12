package com.nrb.maledisease.auth.domain;

/**
 * Created by zhangyunfei on 02/12/2016.
 */
public class PatientAuth {

    private int id;

    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
