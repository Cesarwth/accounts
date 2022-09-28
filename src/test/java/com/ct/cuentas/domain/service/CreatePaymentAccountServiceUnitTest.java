package com.ct.cuentas.domain.service;

import com.ct.cuentas.application.response.PaymentResponse;
import com.ct.cuentas.domain.dto.AccountDto;
import com.ct.cuentas.domain.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CreatePaymentAccountServiceUnitTest {

    private AccountRepository accountRepository;
    private CreatePaymentAccountService createPaymentAccountService;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        createPaymentAccountService = new CreatePaymentAccountService(accountRepository);
    }

    @Test
    void shouldCreatePaymentAccount_thenSaveIt()
    {
        AccountDto accountDto = new AccountDto(1234567890L, 9876543210L, new BigDecimal(100));
        PaymentResponse accountExpectedResponse = new PaymentResponse(12345L,new BigDecimal(10), 12346L, new BigDecimal(100));

        PaymentResponse accountResponse = createPaymentAccountService.createPaymentAccount(accountDto);
        assertEquals(accountExpectedResponse, accountResponse);
    }
}
