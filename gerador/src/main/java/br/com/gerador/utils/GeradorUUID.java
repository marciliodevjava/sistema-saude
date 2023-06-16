package br.com.gerador.utils;

import br.com.gerador.domain.Uuid;
import br.com.gerador.repository.UuidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GeradorUUID {
    @Autowired
    private UuidRepository uuidRepository;

    public String getIdentificador(){
        UUID identificador = UUID.randomUUID();
        Uuid uuid;
        String uuidGerado;
        do {
            uuidGerado = String.valueOf(identificador);
            uuid = uuidRepository.findByuuidGerado(uuidGerado);
        } while (uuid.equals(null));

        uuid = uuidRepository.save(uuid);
        return uuidGerado;
    }
}
