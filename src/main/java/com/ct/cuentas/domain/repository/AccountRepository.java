package com.ct.cuentas.domain.repository;

import com.ct.cuentas.infrastructure.entity.Account;

import java.math.BigDecimal;

public interface AccountRepository {

    Account findByAccountNumber(Long accountNumber);

    Account updateAccountDebit(Account account, BigDecimal amount);

    Account updateAccountCredit(Account account, BigDecimal amount);
}
