package br.com.funcionario.dto;

import java.time.LocalDateTime;

public record Health(String api, LocalDateTime hora, int status) {
}
