package com.nrb.maledisease.auth.api;

import com.nrb.maledisease.auth.domain.Patient;
import com.nrb.maledisease.auth.service.AuthService;
import com.nrb.maledisease.common.Result;
import com.nrb.maledisease.common.exception.ParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by zhangyunfei on 02/12/2016.
 */
@RestController
public class PatientApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApi.class);

    @Resource
    private AuthService authService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@Valid Patient patient, Errors errors) {
        if (errors.hasErrors()) {
            throw new ParamException(errors);
        }
        boolean flag = authService.register(patient);
        return Result.buildSuccessResult(flag);
    }

    @RequestMapping("test")
//    @PreAuthorize("hasRole('ROLE_TEST')")
    public String test() {
        return "test";
    }
}
