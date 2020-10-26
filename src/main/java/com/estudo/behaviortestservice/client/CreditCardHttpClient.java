package com.estudo.behaviortestservice.client;

import com.estudo.behaviortestservice.model.CreditCardLimit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "CreditCardHttpClient", url = "${url.credit-card}")
public interface CreditCardHttpClient {

    @GetMapping(value = "/credit/limit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Optional<CreditCardLimit> getLimit(@PathVariable("id") final String id);
}
