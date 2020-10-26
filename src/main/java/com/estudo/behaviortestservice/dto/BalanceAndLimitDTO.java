package com.estudo.behaviortestservice.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class BalanceAndLimitDTO {

    private BigDecimal available;
    private BigDecimal creditAvaiable;
    private BigDecimal creditTotal;
    private BigDecimal debitAvailable;
    private BigDecimal debitTotal;

    public BalanceAndLimitDTO() {
    }

    public BalanceAndLimitDTO(
            BigDecimal available,
            BigDecimal creditAvaiable,
            BigDecimal creditTotal,
            BigDecimal debitAvailable,
            BigDecimal debitTotal
    ) {
        this.available = available;
        this.creditAvaiable = creditAvaiable;
        this.creditTotal = creditTotal;
        this.debitAvailable = debitAvailable;
        this.debitTotal = debitTotal;
    }
}
