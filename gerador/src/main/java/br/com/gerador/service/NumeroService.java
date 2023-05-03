package br.com.gerador.service;

import br.com.gerador.domain.Numero;
import br.com.gerador.dto.NumeroDto;
import br.com.gerador.repository.NumeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NumeroService {

    @Autowired
    private NumeroRepository numeroRepository;

    public NumeroDto geraNumero(Long id){
        Numero consulta = numeroRepository.findTopByOrderByIdDesc();

        Integer numero = consulta.getNumero();
        Numero inserir = this.montarDados(numero, id);

        this.numeroRepository.save(inserir);

        return new NumeroDto(inserir.getNumero(), inserir.getData());
    }

    private Numero montarDados(Integer numero, Long id) {
        Numero numeroInserir = new Numero();
        LocalDateTime dateTime = LocalDateTime.now();
        Integer valor = 1;
        Integer soma = numero + valor;

        numeroInserir.setNumero(soma);
        numeroInserir.setData(dateTime);
        numeroInserir.setIdFuncionario(id);

        return numeroInserir;
    }
}
