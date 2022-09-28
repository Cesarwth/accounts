package com.ct.cuentas.infrastructure.repository.postgresql;

import com.ct.cuentas.application.response.PaymentResponse;
import com.ct.cuentas.domain.dto.AccountDto;
import com.ct.cuentas.domain.repository.AccountRepository;
import com.ct.cuentas.domain.service.CreatePaymentAccountService;
import com.ct.cuentas.infrastructure.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PostgresDbAccountRepositoryUnitTest {

    private PostgresDbAccountRepository postgresDbAccountRepository;

    @BeforeEach
    void setUp() {
        postgresDbAccountRepository = mock(PostgresDbAccountRepository.class);
    }

    @Test
    void shouldReturnAnAccount_WhenTheInputAccountIsCorrect()
    {
        Long accountNumber =1234567890L;
        Account accountResponse = postgresDbAccountRepository.findByAccountNumber(accountNumber);

        assertEquals(accountResponse, accountResponse);
    }
}
