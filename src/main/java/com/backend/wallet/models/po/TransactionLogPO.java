package com.backend.wallet.models.po;

import com.backend.wallet.constant.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Table
@AllArgsConstructor
@NoArgsConstructor
public class TransactionLogPO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long walletId;

    BigDecimal beforeBalance;

    BigDecimal afterBalance;

    @Enumerated(EnumType.STRING)
    TransactionType type;

    Date createdTime;

}
