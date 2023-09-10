package com.backend.wallet.models.po;

import com.backend.wallet.constant.EUserRole;
import com.backend.wallet.constant.EUserState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPO implements Serializable {

    private static final long serialVersionUID = -686545107109106509L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Enumerated(EnumType.STRING)
    EUserRole role;

    @Enumerated(EnumType.STRING)
    EUserState state;

    String username;

    String email;

    String password;

    Date createdTime;
}
