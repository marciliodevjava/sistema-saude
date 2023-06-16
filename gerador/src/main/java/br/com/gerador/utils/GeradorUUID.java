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
        UUID identificador = UUID.randomUUID();
        Uuid uuid;
        String uuidGerado;
        do {
            uuidGerado = String.valueOf(identificador);
            uuid = uuidRepository.findByuuidGerado(uuidGerado);
        } while (uuid != null);

        Uuid uuidGravar = new Uuid();
        uuidGravar.setProjeto(Projeto.GERADOR);
        uuidGravar.setData(new Date());
        uuidGravar.setHora(LocalTime.now());
        uuidGravar.setUuidGerado(uuidGerado);
        String uuidString = String.valueOf(uuidRepository.save(uuidGravar).getUuidGerado());
        return uuidString;
    }
}
