package br.com.gerador.resource;

import br.com.gerador.domain.Numero;
import br.com.gerador.dto.NumeroDto;
import br.com.gerador.repository.NumeroRepository;
import br.com.gerador.service.NumeroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class NumerosResourceTest {

    @Autowired
    private NumeroService numeroService;

    @Autowired
    private NumeroRepository numeroRepository;

    @Test
    @DisplayName("Teste Gerador o Funcionario")
    void geradorPrimeiroFuncionario(){
        Numero numero = new Numero(null, 001, LocalDateTime.now());
        numero = numeroRepository.save(numero);
        Assertions.assertEquals(001, numero.getNumero());
    }

    @Test
    @DisplayName("Teste Gerador numero Funcionario")
    void geradorNumeroFuncionario(){
        NumeroDto resposta = numeroService.geraNumero();
        Assertions.assertEquals(2, resposta.getNumero());
    }
}
