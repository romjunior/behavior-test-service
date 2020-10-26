package com.estudo.behaviortestservice.resource;

import com.estudo.behaviortestservice.service.BalanceAndLimitsService;
import com.estudo.behaviortestservice.dto.BalanceAndLimitDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalancesResource {

    private final BalanceAndLimitsService balanceAndLimitsService;

    public BalancesResource(BalanceAndLimitsService balanceAndLimitsService) {
        this.balanceAndLimitsService = balanceAndLimitsService;
    }

    @GetMapping("/balances-and-limits/{id}")
    public ResponseEntity<BalanceAndLimitDTO> getBalanceAndLimits(@PathVariable("id") final String id) {
        return balanceAndLimitsService.getBalancesAndLimits(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
