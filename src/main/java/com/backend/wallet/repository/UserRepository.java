package com.backend.wallet.repository;

import com.backend.wallet.models.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserPO, Long> {

    Optional<UserPO> findByUsername(String username);
}
