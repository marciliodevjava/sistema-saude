package br.com.eureka.eurekaserve.dto;

import java.time.LocalDateTime;

public record Health(String apiEureka, LocalDateTime now, int codigo) {
}
