package com.estudo.behaviortestservice.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class DebitCardLimit {
    private BigDecimal available;
    private BigDecimal used;

    public DebitCardLimit() {
    }

    public DebitCardLimit(BigDecimal available, BigDecimal used) {
        this.available = available;
        this.used = used;
    }
}
