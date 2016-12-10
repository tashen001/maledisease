package com.nrb.maledisease.common;

/**
 * Created by zhangyunfei on 27/11/2016.
 */
public enum ResultCodeEnum {

    SUCCESS("200"),INVALIDPARAM("400"),EXCEPTION("500"),BUSINESSERROR("520");

    private String code;

    private ResultCodeEnum(String code) {
        this.code = code;
    }

    public String value() {
        return code;
    }

}
