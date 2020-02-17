package com.example.scooterRentalApp.exception;

import com.example.scooterRentalApp.common.ConstErrorMsg;

public class CommonException extends RuntimeException {

    private ConstErrorMsg constErrorMsg;

    public CommonException(ConstErrorMsg constErrorMsg) {
        this.constErrorMsg = constErrorMsg;
    }

    public ConstErrorMsg getConstErrorMsg() {
        return constErrorMsg;
    }
}
