package com.ct.cuentas.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name= "account")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account", nullable = false, unique = true)
    private Long id;

    @Column(name = "account_number", unique = true)
    private Long acccountNumber;

    @Column(name = "balance")
    private BigDecimal finalBalance;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "transaction_type")
    private Character transactionType;

    @Column(name = "account_type")
    private Character accountType;

}
