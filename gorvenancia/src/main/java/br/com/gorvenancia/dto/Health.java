package br.com.gorvenancia.dto;

import java.time.LocalDateTime;

public record Health(String apiFuncionario, LocalDateTime now, int codigo) {
}
