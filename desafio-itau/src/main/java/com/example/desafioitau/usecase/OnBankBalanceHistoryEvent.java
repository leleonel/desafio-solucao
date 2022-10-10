package com.example.desafioitau.usecase;


import com.example.desafioitau.repositories.dto.BankBalanceAlertHistory;

import lombok.Data;


import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class OnBankBalanceHistoryEvent {


    public static BankBalanceAlertHistory saveBankBalanceAlertHistory(Long idConta){

        BankBalanceAlertHistory bankBalanceAlertHistory = new BankBalanceAlertHistory();

        bankBalanceAlertHistory.setIdConta(idConta);
        bankBalanceAlertHistory.setNotificationTime(Timestamp.valueOf(LocalDateTime.now()));

        return bankBalanceAlertHistory;

    }

}
