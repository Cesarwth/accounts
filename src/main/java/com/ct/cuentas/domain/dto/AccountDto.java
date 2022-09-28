package com.ct.cuentas.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {

    private final Long accountOrigin;
    private final Long accountTarget;
    private final BigDecimal amount;

    @JsonCreator
    public AccountDto(@JsonProperty("accountOrigin") final Long accountOrigin, @JsonProperty("accountTarget") final Long accountTarget, @JsonProperty("amount") final BigDecimal amount) {
        this.accountOrigin = accountOrigin;
        this.accountTarget = accountTarget;
        this.amount = amount;
    }
}
