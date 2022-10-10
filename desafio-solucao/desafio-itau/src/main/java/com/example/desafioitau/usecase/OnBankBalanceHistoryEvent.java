package com.example.desafioitau.usecase;


import com.example.desafioitau.repositories.dto.BankBalanceAlertHistory;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class OnBankBalanceHistoryEvent {


    public static BankBalanceAlertHistory createBankBalanceAlertHistory(Long idConta){

        BankBalanceAlertHistory bankBalanceAlertHistory = new BankBalanceAlertHistory();

        bankBalanceAlertHistory.setIdConta(idConta);
        bankBalanceAlertHistory.setNotificationTime(Timestamp.valueOf(LocalDateTime.now()));

        return bankBalanceAlertHistory;

    }

}
