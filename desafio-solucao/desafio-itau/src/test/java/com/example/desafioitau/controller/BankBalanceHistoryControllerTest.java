package com.example.desafioitau.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class BankBalanceHistoryControllerTest {


    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    BankBalanceHistoryConsultController controller;

    @DisplayName("Should return 204 when the id has no history")
    @ParameterizedTest(name = "With Id_conta {0}")
    @ValueSource(strings = {"142536987"})
    public void shouldGetBalanceHistory(Long idConta) throws Exception {
        mockMvc.perform(get("/api/contas/consulta-historico/{Id_conta}", idConta))
                .andExpect(status().isNoContent());
    }

    @DisplayName("Should return 404 when the id not found")
    @ParameterizedTest(name = "With Id_conta {0}")
    @ValueSource(strings = {"0"})
    public void shouldNotGetBalanceHistory(Long idConta) throws Exception {
        mockMvc.perform(get("/api/contas/consulta-historico/{Id_conta}", idConta))
                .andExpect(status().isNotFound());
    }





}



