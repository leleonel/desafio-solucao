package com.example.desafioitau.controller;

import com.example.desafioitau.repositories.BankBalanceAlertHistoryRepository;
import com.example.desafioitau.repositories.dto.BankBalanceAlertHistory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contas/consulta-historico")
@Validated
@RequiredArgsConstructor
public class BankBalanceHistoryConsultController {

    @Autowired
    private final BankBalanceAlertHistoryRepository repository;

    @RequestMapping(path = "/{Id_conta}", method = RequestMethod.GET)
    @Operation(summary = "Consult bank balance history",
            description = "Consult bank balance history of alerts sent"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation success", content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BankBalanceAlertHistory.class)))

            }),
            @ApiResponse(responseCode = "204", description = "No results", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Id not found", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<String> getBalanceHistory (
            @Parameter(
                    name = "Id_conta",
                    allowEmptyValue = false,
                    description = "Filter for get history of message sent when bank balance negative"
            )
            @PathVariable Long idConta) {

        HttpEntity<BankBalanceAlertHistory> response = new HttpEntity<>(repository.findById(String.valueOf(idConta)).get());

        return ResponseEntity.ok(response.getBody().toString());
    }




}
