package com.example.desafioitau.usecase;

import com.example.desafioitau.event.Data;
import com.example.desafioitau.publishers.PublishMessageSns;
import com.example.desafioitau.repositories.BankBalanceAlertHistoryRepository;
import com.example.desafioitau.repositories.dto.BankBalanceAlertHistory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class OnBankBalanceConsult  {


    @Autowired
    private BankBalanceAlertHistoryRepository bankBalanceAlertHistoryRepository;


    public Boolean sendMessageIfBalanceIsNegative(Data data, Long idConta){

        if (data.getSaldo().doubleValue() < 0){
            PublishMessageSns.pubTopic();
            var bankBalanceAlertHistory = OnBankBalanceHistoryEvent.saveBankBalanceAlertHistory(idConta);
            bankBalanceAlertHistoryRepository.save(bankBalanceAlertHistory);
            return true;

        }
        return false;
    }



}
