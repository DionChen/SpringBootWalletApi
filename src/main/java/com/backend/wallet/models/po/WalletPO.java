package com.backend.wallet.models.po;

import com.backend.wallet.constant.EWalletState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "walltes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class WalletPO implements Serializable {

    private static final long serialVersionUID = 3646337398420433959L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long userId;

    BigDecimal balance;

    @Enumerated(EnumType.STRING)
    EWalletState State;
}
