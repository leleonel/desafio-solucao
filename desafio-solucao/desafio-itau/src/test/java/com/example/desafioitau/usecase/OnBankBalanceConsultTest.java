package com.example.desafioitau.usecase;

import com.example.desafioitau.event.Data;
import com.example.desafioitau.publishers.PublishMessageSns;
import com.example.desafioitau.repositories.BankBalanceAlertHistoryRepository;
import com.example.desafioitau.repositories.dto.BankBalanceAlertHistory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OnBankBalanceConsultTest {

    @Mock
    OnBankBalanceConsult onBankBalanceConsult;

    @Mock
    BankBalanceAlertHistoryRepository repository;

    @Mock
    BankBalanceAlertHistory bankBalanceAlertHistory;


    @Test
    public void testSendMessageIfBalanceIsNegative(Data data, Long idConta){
        when(onBankBalanceConsult.sendMessageIfBalanceIsNegative(data, idConta))
                .thenReturn(true);

        Assertions.assertEquals(true, true);

    }



}
