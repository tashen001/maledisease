package com.nrb.maledisease.auth.dao;

import com.nrb.maledisease.auth.domain.PatientAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhangyunfei on 02/12/2016.
 */
@Mapper
@Component
public interface PatientAuthDao {

    @Select("select a.authority as authority from auth a, patient_auth pr where a.id=pr.auth_id and pr.patient_id=#{patientId}")
    List<PatientAuth> getAuthByPatient(long patientId);
}
