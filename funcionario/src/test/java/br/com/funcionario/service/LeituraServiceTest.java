package br.com.funcionario.service;

import br.com.funcionario.dto.response.FuncionarioCompleRetornoDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LeituraServiceTest {

    @Autowired
    private LeituraService leituraService;

    @Test
    @DisplayName("Teste de salvar um funcionario completo.")
    void trazUmFuncionario() {
        FuncionarioCompleRetornoDto funcionarioCompleRetornoDto = leituraService.funcionarioCompleto(2L);

        Assertions.assertEquals("1a30f7a8-6674-43d1-86f3-2693559e900a", funcionarioCompleRetornoDto.getIdentificadorFunciona());
    }
}
