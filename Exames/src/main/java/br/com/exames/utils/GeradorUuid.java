package br.com.exames.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GeradorUuid {
    private UUID identificador;

    public String getIdentificador() {
        this.identificador = UUID.randomUUID();
        String uuid = String.valueOf(this.identificador);
        return uuid;
    }
}
