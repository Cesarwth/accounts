package com.ct.cuentas.domain.service;

import com.ct.cuentas.application.response.PaymentResponse;
import com.ct.cuentas.domain.dto.AccountDto;

public interface PaymentAccountService {

    PaymentResponse createPaymentAccount(AccountDto accountDto);
}
