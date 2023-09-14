package com.backend.wallet.Controller;


import com.backend.wallet.config.security.JwtAuthTokenService;
import com.backend.wallet.models.dto.LoginRequestDTO;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @Resource
    JwtAuthTokenService jwtAuthTokenService;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequestDTO loginRequestDTO) {

    }

    @PutMapping("/logout")
    public void logout() {

    }
}
