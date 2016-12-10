package com.nrb.maledisease.patient.dao;

import com.nrb.maledisease.patient.domain.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyunfei on 02/12/2016.
 */
@Mapper
@Component
public interface PatientDao {

    @Insert("insert into patient (patient_name, password) VALUES (#{patientName}, #{password} )")
    boolean addPatient(Patient patient);

    @Select("select id, patient_name as patientName, password from patient where patient_name = #{patientName}")
    Patient getPatientByName(String patientName);
}
