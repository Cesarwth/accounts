package com.ct.cuentas.infrastructure.repository.postgresql;

import com.ct.cuentas.domain.repository.AccountRepository;
import com.ct.cuentas.infrastructure.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class PostgresDbAccountRepository implements AccountRepository {

    private final SpringDataPostgresAccountRepository accountRepository;

    @Autowired
    public PostgresDbAccountRepository(SpringDataPostgresAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findByAccountNumber(Long accountNumber){
        Account account = accountRepository.getReferenceByAccount(accountNumber);
        if (!account.equals(null)){
            return account;
        }
        else
            return null;
    }

    public Account updateAccountDebit(Account accountOrigin, BigDecimal amount){
        Account accountDebit = new Account();
        accountDebit.setAcccountNumber(accountOrigin.getAcccountNumber());
        accountDebit.setFinalBalance(accountOrigin.getFinalBalance().subtract(amount));
        accountDebit.setTransactionDate(new Date());
        accountDebit.setAccountType(accountOrigin.getAccountType());
        accountDebit.setTransactionType('D');

        return accountDebit;
    }

    public Account updateAccountCredit(Account accountTarget, BigDecimal amount){
        Account accountCredit = new Account();
        accountCredit.setAcccountNumber(accountTarget.getAcccountNumber());
        accountCredit.setFinalBalance(accountTarget.getFinalBalance().add(amount));
        accountCredit.setTransactionDate(new Date());
        accountCredit.setAccountType(accountTarget.getAccountType());
        accountCredit.setTransactionType('C');

        return accountCredit;
    }

}
