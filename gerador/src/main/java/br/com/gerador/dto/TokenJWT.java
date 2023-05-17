package br.com.gerador.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.time.LocalDateTime;

public record TokenJWT(String login, UsernamePasswordAuthenticationToken token, LocalDateTime dataInicial,
                       LocalDateTime dataFinal) {
}
