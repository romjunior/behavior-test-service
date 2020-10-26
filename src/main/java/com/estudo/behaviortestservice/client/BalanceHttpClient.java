package com.estudo.behaviortestservice.client;

import com.estudo.behaviortestservice.model.Balance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "BalanceHttClient", url = "${url.balance}")
public interface BalanceHttpClient {

    @GetMapping(value = "/balance/{id}")
    Optional<Balance> getBalance(@PathVariable("id") final String id);

}
