package br.com.gerador.utils;

import br.com.gerador.domain.Uuid;
import br.com.gerador.domain.enuns.Projeto;
import br.com.gerador.repository.UuidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Component
public class GeradorUUID {
    @Autowired
    private UuidRepository uuidRepository;

    public String getIdentificador() {
        UUID identificador;
        Uuid uuid;
        String uuidGerado;
        do {
            identificador = UUID.randomUUID();
            uuidGerado = String.valueOf(identificador);
            uuid = uuidRepository.findByuuidGerado(uuidGerado);
        } while (uuid != null);

        Uuid gravar = new Uuid();
        gravar.setProjeto(Projeto.GERADOR);
        gravar.setData(new Date());
        gravar.setHora(LocalTime.now());
        gravar.setUuidGerado(uuidGerado);
        uuidRepository.save(gravar);
        return uuidGerado;
    }
}
