package com.estudo.behaviortestservice.behavior.balancesandlimits;

import com.estudo.behaviortestservice.dto.BalanceAndLimitDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BalanceAndLimitsStepDefs {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    private ResultActions resultActions;

    private String id;

    @Dado("que o usuario com o {string}")
    public void que_o_usuario_com_o(String id) {
        this.id = id;
    }

    @Quando("ele consultar o saldo e limites")
    public void quandoEleConsultarOSaldoELimites() throws Exception {
        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/balances-and-limits/" + id));
    }

    @Entao("ele deve retornar a seguinte resposta")
    public void eleDeveRetornarASeguinteResposta(final String responseJson) throws Exception {
        final var balanceAndLimits = objectMapper.readValue(responseJson, BalanceAndLimitDTO.class);

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.available").value(is(balanceAndLimits.getAvailable().doubleValue())))
                .andExpect(jsonPath("$.creditAvaiable").value(is(balanceAndLimits.getCreditAvaiable().doubleValue())))
                .andExpect(jsonPath("$.creditTotal").value(is(balanceAndLimits.getCreditTotal().doubleValue())))
                .andExpect(jsonPath("$.debitAvailable").value(is(balanceAndLimits.getDebitAvailable().doubleValue())))
                .andExpect(jsonPath("$.debitTotal").value(is(balanceAndLimits.getDebitTotal().doubleValue())));
    }

    @Entao("ele deve retonar a resposta com o status {string}")
    public void eleDeveRetornarARespostaComOStatus(final String status) throws Exception {
        resultActions.andExpect(status().is(Integer.parseInt(status)));
    }
}
