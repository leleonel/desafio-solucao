package com.example.desafioitau.subscribers;

import com.example.desafioitau.event.BankBalanceUpdateReceived;
import com.example.desafioitau.services.SqsService;
import com.example.desafioitau.config.SqsConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;

import java.util.*;
import java.util.stream.Collectors;

public class BankBalanceUpdateSubscriber {

    final SqsConfig SQSCONFIG = new SqsConfig();
    final String QUEUENAME = "movimentacoes_conta";


    public BankBalanceUpdateReceived OnMessageReceived() throws Exception {

        SqsClient sqsClient = SQSCONFIG.createSqsClient();
        String queueUrl = SQSCONFIG.listSqsQueueUrl(sqsClient, QUEUENAME);
        BankBalanceUpdateReceived bankBalanceUpdateReceived;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Message> messages = SqsService.receiveMessages(sqsClient, queueUrl);

        for (Message message :
                messages) {
            Map<String, MessageAttributeValue> entries = message.messageAttributes();

            Map<String,String> newMap = entries.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stringValue()));
            Gson gson1 = new Gson();
            String jsonFromMap = gson1.toJson(newMap);
            bankBalanceUpdateReceived = gson1.fromJson(jsonFromMap, BankBalanceUpdateReceived.class);
            System.out.println("JSON FROM MAP :" + bankBalanceUpdateReceived.getAgencia() + ", " + bankBalanceUpdateReceived.getDigitoConta());

            return bankBalanceUpdateReceived;

            /* In case of the message returns in the body message as Json.

            Gson gson = new Gson();
            BankBalanceUpdateReceived bankBalanceUpdateReceived1 = gson.fromJson(message.body(), BankBalanceUpdateReceived.class);*/

        }
        return null;
    }
}
