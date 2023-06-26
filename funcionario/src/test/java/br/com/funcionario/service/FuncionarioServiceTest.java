package br.com.funcionario.service;

import br.com.funcionario.domain.FuncionarioClt;
import br.com.funcionario.domain.FuncionarioCnpj;
import br.com.funcionario.domain.Salario;
import br.com.funcionario.domain.enuns.EstadoCivilEnum;
import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import br.com.funcionario.domain.enuns.FuncaoFuncionarioEnum;
import br.com.funcionario.domain.enuns.GrauParentescoEnum;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.request.*;
import br.com.funcionario.dto.response.FuncionarioRetornoDto;
import br.com.funcionario.service.v0.FuncionarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FuncionarioServiceTest {
    @Autowired
    private FuncionarioService funcionarioService;
    private final Integer NUMERO_FUNCINARIO = 652;
    private final String NOME_FUNCIONARIO = "Carlos Henrique";
    private final String DATA_NASCIMENTO_FUNCIONARIO = "1994/11/01";
    private final String RG_FUNCIONARIO = "2635698";
    private final String DDD_FUNCIONARIO = "61";
    private final String TELEFONE_FUNCIONARIO = "983622881";
    private final String EMAIL_FUNCIONARIO = "teste@teste.spring.com";
    private final String HORARIO_INICIAL_FUNCIONARIO = "09:00:00";
    private final String HORARIO_FINAL_FUNCIONARIO = "18:00:00";
    private final String CPF_FUNCIONARIO = "525.759.180-49";
    private final String CNPJ = "44.155.548/0001-86";
    private final BigDecimal SALARIO_FUNCIONARIO = BigDecimal.valueOf(2800.00);
    private final BigDecimal VALOR_ALIMENTACAO_FUNCIONARIO = BigDecimal.valueOf(573.73);
    private final BigDecimal VALOR_TRANSPORTE_FUNCIONARIO = BigDecimal.valueOf(850.00);
    private final int DIAS_AUXILIO_ALIMENTACAO_FUNCIONARIO = 22;
    private final int DIAS_AUXILIO_TRANSPORTE_FUNCIONARIO = 22;
    private final String NOME_DEPENDENTE = "Pedro paulo";
    private final String CPF_DEPENDENTE = "710.347.830-92";
    private final String RG_DEPENDENTE = "25849163";
    private final String DATA_NASCIMENTO_DEPENDENTE = "2013/06/26";
    private final GrauParentescoEnum GRAU_PARENTESCO_DEPENDENTE = GrauParentescoEnum.FILHO;
    private final String CEP_ENDERECO_FUNCIONARIO = "72815430";
    private final String LOGRADOURO_ENDERECO_FUNCIONARIO = "Rua 24 Lote 74 Quadra 15";
    private final String NUMERO_ENDERECO_FUNCIONARIO = "15";
    private final String BAIRRO_ENDERECO_FUNCIONARIO = "Avenida Pebroga";
    private final String CIDADE_ENDERECO_FUNCIONARIO = "São paulo";
    private final String UP_ENDERECO_FUNCIONARIO = "SP";

    @Test
    @DisplayName("Teste de salvar um funcionario completo.")
    void salvarFuncionarioTest() throws ParseException {
        FuncionarioDto funcionario = this.gerarFuncionario();

        FuncionarioRetornoDto funcionarioRetornoDto = funcionarioService.salvarFuncionario(funcionario);

        Assertions.assertEquals("ATIVO", funcionarioRetornoDto.getEstadoFuncionarioEnum().toString());
    }

    @Test
    @DisplayName("Teste de salvar somente um funcionario.")
    void salvarSomenteFuncionario() {
        FuncionarioDto funcionario = new FuncionarioDto();

        FuncionarioRetornoDto funcionarioRetornoDto = funcionarioService.salvarSomenteFuncionario(funcionario);

        Assertions.assertEquals("ATIVO", funcionarioRetornoDto.getEstadoFuncionarioEnum().toString());
    }

    private FuncionarioDto gerarFuncionario() {
        FuncionarioDto funcionario = new FuncionarioDto();

        funcionario.setNumeroFuncionario(NUMERO_FUNCINARIO);
        funcionario.setEstadoFuncionarioEnum(EstadoFuncionarioEnum.ATIVO);
        funcionario.setFuncionarioClt(this.gerarFuncionarioClt(new FuncionarioClt()));
        funcionario.setFuncionarioCnpj(this.gerarFuncionarioCnpj(new FuncionarioCnpj()));

        return funcionario;
    }

    private FuncionarioCnpjDto gerarFuncionarioCnpj(FuncionarioCnpj funcionarioCnpj) {
        FuncionarioCnpjDto funcionarioCnpjDto = new FuncionarioCnpjDto();

        funcionarioCnpjDto.setFuncaoFuncionarioEnum(FuncaoFuncionarioEnum.ASSISTENTE_ADMINISTRATIVO);
        funcionarioCnpjDto.setEstadoCivil(EstadoCivilEnum.SOTEIRO);
        funcionarioCnpjDto.setSalario(this.geraSalarioFuncionário(new Salario()));
        funcionarioCnpjDto.setNome(NOME_FUNCIONARIO);
        funcionarioCnpjDto.setDataNascimento(DATA_NASCIMENTO_FUNCIONARIO);
        funcionarioCnpjDto.setCpf(CPF_FUNCIONARIO);
        funcionarioCnpjDto.setCnpj(CNPJ);
        funcionarioCnpjDto.setRg(RG_FUNCIONARIO);
        funcionarioCnpjDto.setDdd(DDD_FUNCIONARIO);
        funcionarioCnpjDto.setTelefone(TELEFONE_FUNCIONARIO);
        funcionarioCnpjDto.setEmail(EMAIL_FUNCIONARIO);
        funcionarioCnpjDto.setHorarioInicial(HORARIO_INICIAL_FUNCIONARIO);
        funcionarioCnpjDto.setHorarioFinal(HORARIO_FINAL_FUNCIONARIO);
        funcionarioCnpjDto.setDependentes(this.gerarDependenteFuncionario(new DependenteDto()));
        funcionarioCnpjDto.setEndereco(this.gerarEnderecoFuncionario(new EnderecoDto()));

        return funcionarioCnpjDto;
    }

    private List<EnderecoDto> gerarEnderecoFuncionario(EnderecoDto endereco) {

        List<EnderecoDto> enderecoDto = new ArrayList<>();
        EnderecoDto addEnderecoDto = new EnderecoDto();

        addEnderecoDto.setCep(CEP_ENDERECO_FUNCIONARIO);
        addEnderecoDto.setLogradouro(LOGRADOURO_ENDERECO_FUNCIONARIO);
        addEnderecoDto.setNumero(NUMERO_ENDERECO_FUNCIONARIO);
        addEnderecoDto.setBairro(BAIRRO_ENDERECO_FUNCIONARIO);
        addEnderecoDto.setCidade(CIDADE_ENDERECO_FUNCIONARIO);
        addEnderecoDto.setUf(UP_ENDERECO_FUNCIONARIO);

        enderecoDto.add(addEnderecoDto);

        return enderecoDto;
    }

    private FuncionarioCltDto gerarFuncionarioClt(FuncionarioClt funcionarioClt) {

        FuncionarioCltDto funcionarioCltDto = new FuncionarioCltDto();

        funcionarioCltDto.setFuncaoFuncionarioEnum(FuncaoFuncionarioEnum.COORDENADORA);
        funcionarioCltDto.setEstadoCivil(EstadoCivilEnum.SOTEIRO);
        funcionarioCltDto.setSalario(this.geraSalarioFuncionário(new Salario()));
        funcionarioCltDto.setNome(NOME_FUNCIONARIO);
        funcionarioCltDto.setDataNascimento(DATA_NASCIMENTO_FUNCIONARIO);
        funcionarioCltDto.setCpf(CPF_FUNCIONARIO);
        funcionarioCltDto.setRg(RG_FUNCIONARIO);
        funcionarioCltDto.setDdd(DDD_FUNCIONARIO);
        funcionarioCltDto.setTelefone(TELEFONE_FUNCIONARIO);
        funcionarioCltDto.setEmail(EMAIL_FUNCIONARIO);
        funcionarioCltDto.setHorarioInicial(HORARIO_INICIAL_FUNCIONARIO);
        funcionarioCltDto.setHorarioFinal(HORARIO_FINAL_FUNCIONARIO);
        funcionarioCltDto.setDependentes(this.gerarDependenteFuncionario((DependenteDto) funcionarioClt.getDependentesList()));
        funcionarioCltDto.setEndereco(this.gerarEnderecoFuncionario((EnderecoDto) funcionarioClt.getEndereco()));

        return funcionarioCltDto;
    }

    private SalarioDto geraSalarioFuncionário(Salario salario) {
        SalarioDto salarioDto = new SalarioDto();

        salarioDto.setSalario(SALARIO_FUNCIONARIO);
        salarioDto.setValorAlimentacao(VALOR_ALIMENTACAO_FUNCIONARIO);
        salarioDto.setTransporte(VALOR_TRANSPORTE_FUNCIONARIO);
        salarioDto.setAuxilioAlimentacao(this.gerarAuxilioAlimentacaoDto(new AuxilioAlimentacaoDto()));
        salarioDto.setAuxilioTransporte(this.gerarAuxilioTransporteDto(new AuxilioTransporteDto()));

        return salarioDto;
    }

    private AuxilioTransporteDto gerarAuxilioTransporteDto(AuxilioTransporteDto auxilioTransporte) {

        AuxilioTransporteDto auxilioTransporteDto = new AuxilioTransporteDto();

        auxilioTransporteDto.setDias(DIAS_AUXILIO_TRANSPORTE_FUNCIONARIO);
        auxilioTransporteDto.setValorPassagem(VALOR_TRANSPORTE_FUNCIONARIO);

        return auxilioTransporteDto;
    }

    private AuxilioAlimentacaoDto gerarAuxilioAlimentacaoDto(AuxilioAlimentacaoDto auxilioAlimentacao) {

        AuxilioAlimentacaoDto auxilioAlimentacaoDto = new AuxilioAlimentacaoDto();

        auxilioAlimentacaoDto.setDias(DIAS_AUXILIO_ALIMENTACAO_FUNCIONARIO);
        auxilioAlimentacaoDto.setValor(VALOR_ALIMENTACAO_FUNCIONARIO);

        return auxilioAlimentacaoDto;
    }

    private List<DependenteDto> gerarDependenteFuncionario(DependenteDto dependente) {

        List<DependenteDto> dependenteDto = new ArrayList<>();

        DependenteDto addDependente = new DependenteDto();
        addDependente.setNome(NOME_DEPENDENTE);
        addDependente.setCpf(CPF_DEPENDENTE);
        addDependente.setRg(RG_DEPENDENTE);
        addDependente.setDataNascimento(DATA_NASCIMENTO_DEPENDENTE);
        addDependente.setGrauParentescoEnum(GRAU_PARENTESCO_DEPENDENTE);

        dependenteDto.add(addDependente);

        return dependenteDto;
    }
}
