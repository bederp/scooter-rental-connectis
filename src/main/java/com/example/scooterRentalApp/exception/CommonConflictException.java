package com.example.scooterRentalApp.exception;

import com.example.scooterRentalApp.common.ConstErrorMsg;

public class CommonConflictException extends CommonException {

    public CommonConflictException(ConstErrorMsg constErrorMsg) {
        super(constErrorMsg);
    }
}
