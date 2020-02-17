package com.example.scooterRentalApp.api.response;

import com.example.scooterRentalApp.api.BasicResponse;

public class CreateUserAccountResponse extends BasicResponse {

    private Long accountId;

    public CreateUserAccountResponse() {
    }

    public CreateUserAccountResponse(String responseMsg, Long accountId) {
        super(responseMsg);
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
