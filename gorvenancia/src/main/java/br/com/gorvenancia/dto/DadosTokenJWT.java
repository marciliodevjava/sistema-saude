package br.com.gorvenancia.dto;

import java.time.Instant;
import java.time.LocalDateTime;

public record DadosTokenJWT(String login, String tokenJWT, LocalDateTime dataInicial, LocalDateTime dataFinal) {
}
