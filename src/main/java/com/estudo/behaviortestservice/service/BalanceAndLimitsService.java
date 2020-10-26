package com.estudo.behaviortestservice.service;

import com.estudo.behaviortestservice.client.BalanceHttpClient;
import com.estudo.behaviortestservice.client.CreditCardHttpClient;
import com.estudo.behaviortestservice.client.DebitCardHttpClient;
import com.estudo.behaviortestservice.dto.BalanceAndLimitDTO;
import com.estudo.behaviortestservice.model.Balance;
import com.estudo.behaviortestservice.model.CreditCardLimit;
import com.estudo.behaviortestservice.model.DebitCardLimit;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BalanceAndLimitsService {

    private final BalanceHttpClient balanceHttpClient;

    private final CreditCardHttpClient creditCardHttpClient;

    private final DebitCardHttpClient debitCardHttpClient;

    public BalanceAndLimitsService(
            BalanceHttpClient balanceHttpClient,
            CreditCardHttpClient creditCardHttpClient,
            DebitCardHttpClient debitCardHttpClient
    ) {
        this.balanceHttpClient = balanceHttpClient;
        this.creditCardHttpClient = creditCardHttpClient;
        this.debitCardHttpClient = debitCardHttpClient;
    }

    public Optional<BalanceAndLimitDTO> getBalancesAndLimits(final String id) {
        final var balance = balanceHttpClient.getBalance(id);
        final var creditCard = creditCardHttpClient.getLimit(id);
        final var debitCard = debitCardHttpClient.getLimit(id);

        if(balance.isEmpty() && creditCard.isEmpty() && debitCard.isEmpty())
            return Optional.empty();

        return Optional.of(BalanceAndLimitDTO
                .builder()
                .available(balance.map(Balance::getAvailable).orElse(BigDecimal.ZERO))
                .creditAvaiable(creditCard.map(CreditCardLimit::getAvailable).orElse(BigDecimal.ZERO))
                .debitAvailable(debitCard.map(DebitCardLimit::getAvailable).orElse(BigDecimal.ZERO))
                .creditTotal(creditCard.map(creditCardLimit -> calculateTotal(creditCardLimit.getAvailable(), creditCardLimit.getUsed())).orElse(BigDecimal.ZERO))
                .debitTotal(debitCard.map(debitCardLimit -> calculateTotal(debitCardLimit.getAvailable(), debitCardLimit.getUsed())).orElse(BigDecimal.ZERO))
                .build());
    }

    BigDecimal calculateTotal(final BigDecimal available, final BigDecimal used) {
        return available != null
                ? available.add(used)
                : BigDecimal.ZERO;
    }
}
