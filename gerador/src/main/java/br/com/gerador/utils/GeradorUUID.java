package br.com.gerador.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GeradorUUID {

    private UUID identificador;

    public UUID getIdentificador(){
//        do {
            this.identificador = UUID.randomUUID();

//        } while ();
        return identificador;
    }
}
