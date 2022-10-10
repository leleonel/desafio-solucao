package com.example.desafioitau.controller;

import com.example.desafioitau.repositories.BankBalanceAlertHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contas/consulta-saldo")
@Validated
@RequiredArgsConstructor
public class BankBalanceHistoryConsultController {

    @Autowired
    private final BankBalanceAlertHistoryRepository repository;

    @RequestMapping(path = "/saldos/{Id_conta}", method = RequestMethod.GET)
    @Operation(summary = "Consult bank balance",
            description = "Consult bank balance. Its necessary the account id (composed by agencia+conta+dac)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation success", content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BankBalanceUpdateReceived.class)))

            })
    })
    public ResponseEntity<String> getBalance (
            @Parameter(
                    name = "Id_conta",
                    allowEmptyValue = false,
                    description = "Filter for get saldo."
            )
            @PathVariable Long idConta) throws NoSuchFieldException {

        bankBalanceUpdateRepository.findByIdConta(idConta)
                .setSaldo(BigDecimal.valueOf(Double.parseDouble(
                        String.valueOf(ResponseBody.class.getDeclaredField("saldo")))));

        bankBalanceUpdateReceived.getValorMovimento();

        onBalanceUpdateReceived.updateBalance(idConta, BigDecimal.valueOf(bankBalanceUpdateReceived.getValorMovimento()));

        return ResponseEntity.ok("current Balance updated with success");
    }




}
