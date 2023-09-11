package com.backend.wallet.models.po;

import com.backend.wallet.constant.EWalletState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "wallets")
@Entity
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
