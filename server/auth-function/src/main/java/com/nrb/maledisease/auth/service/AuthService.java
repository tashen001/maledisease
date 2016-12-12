package com.nrb.maledisease.auth.service;

import com.nrb.maledisease.auth.dao.PatientAuthDao;
import com.nrb.maledisease.auth.dao.PatientDao;
import com.nrb.maledisease.auth.domain.Patient;
import com.nrb.maledisease.auth.domain.PatientAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyunfei on 27/11/2016.
 */
@Service
public class AuthService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

    @Resource
    private PatientDao patientDao;

    @Resource
    private PatientAuthDao authDao;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Patient patient = patientDao.getPatientByName(name);
        if(patient == null){
            throw new UsernameNotFoundException("not found");
        }
        List<PatientAuth> authList = authDao.getAuthByPatient(patient.getId());

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authList.forEach(auth ->
            authorities.add(new SimpleGrantedAuthority(auth.getAuthority()))
        );

        User user = new User(patient.getPatientName(), patient.getPassword(), authorities);
        return user;
    }

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
