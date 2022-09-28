package com.ct.cuentas.application.request;

import com.ct.cuentas.domain.dto.AccountDto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PaymentRequest {
    private AccountDto accountDto;

    @JsonCreator
    public PaymentRequest(@JsonProperty("account") final AccountDto accountDto){
        this.accountDto = accountDto;
    }
}
