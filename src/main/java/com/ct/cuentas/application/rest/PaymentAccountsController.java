package com.ct.cuentas.application.rest;

import com.ct.cuentas.application.response.PaymentResponse;
import com.ct.cuentas.application.request.PaymentRequest;
import com.ct.cuentas.domain.service.PaymentAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentAccountsController {

    private PaymentAccountService paymentAccountService;

    public PaymentAccountsController(PaymentAccountService paymentAccountService) {
        this.paymentAccountService = paymentAccountService;
    }

    @PostMapping(value="/paymentAccounts")
    PaymentResponse paymentAccount(@RequestBody final PaymentRequest accountRequest){
        PaymentResponse paymentResponse = paymentAccountService.createPaymentAccount(accountRequest.getAccountDto());
        return paymentResponse;
    }
}
