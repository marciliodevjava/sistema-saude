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
import java.util.List;

@SpringBootTest
public class NumerosResourceTest {

    @Autowired
    private NumeroService numeroService;

    @Autowired
    private NumeroRepository numeroRepository;

    @Test
    @DisplayName("Teste Gerador o Funcionario")
    void geradorPrimeiroFuncionario(){
        Numero numero = new Numero(null, 005, LocalDateTime.now(), 2L);
        numero = numeroRepository.save(numero);
        Assertions.assertEquals(005, numero.getNumero());
    }

    @Test
    @DisplayName("Teste Buscar todos os registros")
    void buscarTodosOsRegistros(){
        List<NumeroDto> numero = numeroService.buscarNumeros();
        Integer resultado = numero.size();

        Assertions.assertEquals(resultado, numero.size());
    }

    @Test
    @DisplayName("Teste Gerador numero Funcionario")
    void geradorNumeroFuncionario(){
        NumeroDto resposta = numeroService.geraNumero(6L);
        Assertions.assertEquals(6, resposta.getNumero());
    }
}
