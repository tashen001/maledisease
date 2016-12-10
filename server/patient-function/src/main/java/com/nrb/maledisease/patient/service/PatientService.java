package com.nrb.maledisease.patient.service;

import com.nrb.maledisease.patient.dao.PatientDao;
import com.nrb.maledisease.patient.domain.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by zhangyunfei on 02/12/2016.
 */
@Service
public class PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private PatientDao patientDao;

    @Transactional
    public boolean register(Patient patient) {
        try {
            patient.setPassword(passwordEncoder.encode(patient.getPassword()));
            patientDao.addPatient(patient);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw e;
        }
        return true;
    }
}
