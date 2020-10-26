package com.estudo.behaviortestservice.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Balance {

    private BigDecimal available;

    public Balance() {
    }

    public Balance(BigDecimal available) {
        this.available = available;
    }
}
