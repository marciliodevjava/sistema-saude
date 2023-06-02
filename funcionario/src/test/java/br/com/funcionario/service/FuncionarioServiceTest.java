package br.com.funcionario.service;

import br.com.funcionario.domain.Funcionario;
import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.response.FuncionarioRetornoDto;
import br.com.funcionario.repository.FuncionarioRepository;
import br.com.funcionario.service.v0.FuncionarioService;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import java.text.ParseException;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class FuncionarioServiceTest {
    @Autowired
    private FuncionarioService funcionarioService;
    private final Integer NUMERO_FUNCINARIO = 123;

    @Test
    void salvarFuncionarioTest() throws ParseException {
        FuncionarioDto funcionario = this.gerarFuncionario();

        FuncionarioRetornoDto funcionarioRetornoDto = funcionarioService.salvarFuncionario(funcionario);

        Assertions.assertEquals("ATIVO", funcionarioRetornoDto.getEstadoFuncionarioEnum());
    }

    private FuncionarioDto gerarFuncionario() {
        FuncionarioDto funcionario = new FuncionarioDto();

        funcionario.setEstadoFuncionarioEnum(EstadoFuncionarioEnum.ATIVO);
        funcionario.setFuncionarioClt(null);
        funcionario.setFuncionarioCnpj(null);

        return funcionario;
    }


}
