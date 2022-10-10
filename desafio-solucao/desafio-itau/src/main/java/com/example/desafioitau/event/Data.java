package com.example.desafioitau.event;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {


    @NonNull
    private BigDecimal saldo;


}
