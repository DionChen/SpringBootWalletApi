package com.backend.wallet.models.po;

import com.backend.wallet.constant.EUserRole;
import com.backend.wallet.constant.EUserState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class UserPO implements Serializable {

    private static final long serialVersionUID = -686545107109106509L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Enumerated(EnumType.STRING)
    EUserRole role;

    @Enumerated(EnumType.STRING)
    EUserState state;

    @Column(unique = true)
    String username;

    String email;

    String password;

    Date createdTime;
}
