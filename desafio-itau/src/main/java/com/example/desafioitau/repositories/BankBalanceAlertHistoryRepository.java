package com.example.desafioitau.repositories;

import com.example.desafioitau.repositories.dto.BankBalanceAlertHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankBalanceAlertHistoryRepository extends JpaRepository<BankBalanceAlertHistory, String> {

    BankBalanceAlertHistory saveAndFlush(BankBalanceAlertHistory bankBalanceAlertHistory);

}
