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
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
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
        Numero numero = new Numero(null, "ejflkewjfewifjeiojfiojfio", 005, new Date(), 2L);
        numero = numeroRepository.save(numero);
        Assertions.assertEquals("ejflkewjfewifjeiojfiojfio", numero.getIdentificadorNumero());
    }

    @Test
    @DisplayName("Teste Gerador numero Funcionario")
    void geradorNumeroFuncionario() throws ParseException {
        NumeroDto resposta = numeroService.geraNumero(6L);
        Assertions.assertEquals(6L, resposta.getIdFuncionario());
    }
}
