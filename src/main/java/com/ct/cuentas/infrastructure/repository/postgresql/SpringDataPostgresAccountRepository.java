package com.ct.cuentas.infrastructure.repository.postgresql;

import com.ct.cuentas.infrastructure.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataPostgresAccountRepository extends JpaRepository<Account, Long> {

    @Query("Select a from Account a where a.acccountNumber=?1")
    Account getReferenceByAccount(Long accountNumber);
}
