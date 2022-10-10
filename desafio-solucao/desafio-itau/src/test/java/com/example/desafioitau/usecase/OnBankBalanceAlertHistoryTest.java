package com.example.desafioitau.usecase;


import com.example.desafioitau.repositories.dto.BankBalanceAlertHistory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OnBankBalanceAlertHistoryTest {

    @Mock
    static OnBankBalanceHistoryEvent onBankBalanceAlertHistory;

    @Mock
    static BankBalanceAlertHistory bankBalanceAlertHistory;

    @Test
    public static void testCreateBankBalanceAlertHistory(Long idConta){
        when(onBankBalanceAlertHistory.createBankBalanceAlertHistory(idConta))
                .thenReturn(bankBalanceAlertHistory);
        bankBalanceAlertHistory.setIdConta(idConta);
        bankBalanceAlertHistory.setNotificationTime(Timestamp.valueOf(LocalDateTime.now()));

        doReturn(bankBalanceAlertHistory);

        Assertions.assertEquals(bankBalanceAlertHistory, any());

    }

}
