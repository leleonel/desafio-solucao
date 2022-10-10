package com.example.desafioitau.repositories.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_balance_alert_history")
public class BankBalanceAlertHistory {
    @Id
    @NonNull
    @Column(name = "id_conta")
    private Long idConta;
    @NonNull
    @Column(name = "notification_time")
    private Timestamp notificationTime;

}
