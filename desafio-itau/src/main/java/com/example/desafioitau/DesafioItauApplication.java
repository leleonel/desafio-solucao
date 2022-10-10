package com.example.desafioitau;

import com.example.desafioitau.repositories.BankBalanceAlertHistoryRepository;
import com.example.desafioitau.subscribers.BankBalanceConsultSubscriber;
import com.example.desafioitau.subscribers.BankBalanceUpdateSubscriber;
import com.example.desafioitau.usecase.OnBankBalanceConsult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class DesafioItauApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DesafioItauApplication.class, args);

		BankBalanceAlertHistoryRepository repository;

		//Configura e recebe estímulo Sqs
		var bankBalanceUpdateSubscriber = new BankBalanceUpdateSubscriber();
		//Transforma Sqs em Evento
		var bankBalanceUpdateReceived = bankBalanceUpdateSubscriber.OnMessageReceived();
		//Consme saldo na REST API
		var bankBalanceConsultSubscriber = new BankBalanceConsultSubscriber();
		var bankBalanceConsult = bankBalanceConsultSubscriber.getBankBalanceConsult(bankBalanceUpdateReceived);
		//Verifica se saldo negativo, se sim envia Sns
		var onBankBalanceConsult = new OnBankBalanceConsult();
		onBankBalanceConsult.sendMessageIfBalanceIsNegative(bankBalanceConsult, bankBalanceUpdateReceived.getIdConta());

	}

}
