package br.com.gateway.dto;

import java.time.LocalDateTime;

public record Health(String api, LocalDateTime now, int codigo) {
}
