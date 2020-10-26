package com.estudo.behaviortestservice.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreditCardLimit {
    private BigDecimal available;
    private BigDecimal used;

    public CreditCardLimit() {
    }

    public CreditCardLimit(BigDecimal available, BigDecimal used) {
        this.available = available;
        this.used = used;
    }
}
