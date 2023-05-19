package br.com.gerador.dto;

import java.time.LocalDateTime;

public record Health(String apiGovernancia, LocalDateTime now, int codigo) {
}
