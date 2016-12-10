package com.nrb.maledisease.patient.service;

import com.nrb.maledisease.patient.dao.PatientAuthDao;
import com.nrb.maledisease.patient.dao.PatientDao;
import com.nrb.maledisease.patient.domain.Patient;
import com.nrb.maledisease.patient.domain.PatientAuth;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyunfei on 27/11/2016.
 */
@Service
public class AuthService implements UserDetailsService {

    @Resource
    private PatientDao patientDao;

    @Resource
    private PatientAuthDao authDao;

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

}
