package com.nrb.maledisease.patient.domain;

import java.util.List;

/**
 * Created by zhangyunfei on 02/12/2016.
 */
public class Patient {

    private long id;

    private String patientName;

    private String password;

    private List<PatientAuth> authList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PatientAuth> getAuthList() {
        return authList;
    }

    public void setAuthList(List<PatientAuth> authList) {
        this.authList = authList;
    }
}
