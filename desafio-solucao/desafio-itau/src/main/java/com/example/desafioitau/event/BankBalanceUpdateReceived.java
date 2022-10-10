package com.example.desafioitau.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankBalanceUpdateReceived {

    private Long idConta;
    private String agencia;
    @SerializedName("numero_conta")
    private String numeroConta;
    @SerializedName("digito_conta")
    private String digitoConta;
    @SerializedName("valor_movimento")
    private String valorMovimento;

    public Long getIdConta() {
        return Long.parseLong(String.valueOf(idConta = Long.valueOf(getAgencia() + getNumeroConta() + getDigitoConta())));
    }

}
