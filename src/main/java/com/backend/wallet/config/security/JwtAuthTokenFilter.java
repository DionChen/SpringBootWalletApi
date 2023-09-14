package com.backend.wallet.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    private final JwtAuthTokenService jwtAuthTokenService;

    private final UserDetailsService userDetailsService;

    public JwtAuthTokenFilter(JwtAuthTokenService jwtAuthTokenService, UserDetailsService userDetailsService) {
        this.jwtAuthTokenService = jwtAuthTokenService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional.ofNullable(request.getHeader("Authorization"))
                .filter(v -> v.startsWith("Bearer"))
                .ifPresent(v -> {
                    final String username = jwtAuthTokenService.getSubjectByJwt(v.substring(7));
                    final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                });
        filterChain.doFilter(request, response);
    }
}
