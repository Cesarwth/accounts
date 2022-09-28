package com.ct.cuentas.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
        private Long operationNumberOrigin;
        private BigDecimal balanceOrigin;
        private Long operationNumberTarget;
        private BigDecimal balanceTarget;
}
