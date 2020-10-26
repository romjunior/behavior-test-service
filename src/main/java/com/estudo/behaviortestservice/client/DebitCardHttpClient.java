package com.estudo.behaviortestservice.client;

import com.estudo.behaviortestservice.model.DebitCardLimit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "DebitCardHttpClient", url = "${url.debit-card}")
public interface DebitCardHttpClient {

    @GetMapping(value = "/debit/limit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Optional<DebitCardLimit> getLimit(@PathVariable("id") final String id);

}
