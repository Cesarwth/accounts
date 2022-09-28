package com.ct.cuentas.domain.service;

import com.ct.cuentas.application.response.PaymentResponse;
import com.ct.cuentas.domain.dto.AccountDto;
import com.ct.cuentas.domain.repository.AccountRepository;
import com.ct.cuentas.infrastructure.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class CreatePaymentAccountService implements PaymentAccountService{

    private final AccountRepository accountRepository;

    public CreatePaymentAccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public PaymentResponse createPaymentAccount(AccountDto accountDto) {
        /*para crear el pago se necesita
         * 1. Obtener el cliente y su cuØenta con la cuenta destino
         * 2. Obtener saldo actual de cuenta destino
         * 3. Actualizar saldo final, cuenta origen, fecha transaccion con ammount, cuenta origen de Account
         * 4. Actualizar saldo final, cuenta destino, fecha transaccion con ammount, cuenta destino de Account
         * 5. Obtener informacion de operationNumberOrigin, balanceOrigin, operationNumberTarget, balanceTarget como respuesta */
        //Operaciones de Debito
        Account accountOrigin = accountRepository.findByAccountNumber(accountDto.getAccountOrigin());
        Account accountDebit = accountRepository.updateAccountDebit(accountOrigin, accountDto.getAmount());

        //Operaciones de Credito
        Account accountTarget = accountRepository.findByAccountNumber(accountDto.getAccountTarget());
        Account accountCredit = accountRepository.updateAccountCredit(accountTarget, accountDto.getAmount());

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setOperationNumberOrigin(accountDebit.getId());
        paymentResponse.setBalanceOrigin(accountDebit.getFinalBalance());
        paymentResponse.setOperationNumberTarget(accountCredit.getId());
        paymentResponse.setBalanceTarget(accountCredit.getFinalBalance());

        return paymentResponse;
    }
}
