package br.com.funcionario.service.v0;

import br.com.funcionario.domain.*;
import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.response.*;
import br.com.funcionario.mapper.EscritaMapper;
import br.com.funcionario.repository.*;
import br.com.funcionario.service.imp.FuncionarioServiceImp;
import br.com.funcionario.utils.GeradorUUID;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Transient;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@ComponentScan
public class FuncionarioService implements FuncionarioServiceImp {
    private final Integer NUMERO_DEFALT = 99999;
    @Autowired
    private EscritaMapper escritaMapper;
    @Autowired
    private GeradorUUID geradorUUID;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private FuncionarioCltRepository funcionarioCltRepository;
    @Autowired
    private FuncionarioCnpjRepository funcionarioCnpjRepository;
    @Autowired
    private SalarioRepository salarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private DependenteRepositry dependenteRepositry;
    @Autowired
    private AuxilioAlimentacaoRepository auxilioAlimentacaoRepository;
    @Autowired
    private AuxilioTransporteRepository auxilioTransporteRepository;


    @Override
    @Transient
    public FuncionarioRetornoDto salvarFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) throws ParseException {

        Funcionario funcionarioEscrita = escritaMapper.mapearFuncionario(funcionarioDto);

        FuncionarioClt funcionarioCltEscrita = escritaMapper.mapearEntradaFuncionaClt(funcionarioDto.getFuncionarioClt());
        Salario salarioCltEscrita = escritaMapper.montarEntradaSalario(funcionarioDto.getFuncionarioClt().getSalario());
        AuxilioAlimentacao auxilioAlimentacaoCltEscrita = escritaMapper.montarEntradaAuxilioAlimentacao(funcionarioDto.getFuncionarioClt().getSalario().getAuxilioAlimentacao());
        AuxilioTransporte auxilioTransporteCltEscrita = escritaMapper.montarEntradaAuxilioTransporte(funcionarioDto.getFuncionarioClt().getSalario().getAuxilioTransporte());
        List<Dependente> dependenteCltEscrita = escritaMapper.montarEntradaListaDependente(funcionarioDto.getFuncionarioCnpj().getDependentesList());
        List<Endereco> enderecosCltEscrita = escritaMapper.montarEntradaEndereco(funcionarioDto.getFuncionarioClt().getEndereco());

        FuncionarioCnpj funcionarioCnpjEscrita = escritaMapper.mapearEntradaFuncionaCnpj(funcionarioDto.getFuncionarioCnpj());

        if (Objects.nonNull(funcionarioEscrita)) {
            Funcionario funcionario = funcionarioRepository.save(funcionarioEscrita);
            if (Objects.nonNull(funcionarioCltEscrita))
                funcionarioCltEscrita.setFuncionario(funcionario);
            if (Objects.nonNull(funcionarioCnpjEscrita))
                funcionarioCnpjEscrita.setFuncionario(funcionario);
        }

        if (Objects.nonNull(funcionarioCltEscrita)) {
            FuncionarioClt funcionarioClt = funcionarioCltRepository.save(funcionarioCltEscrita);
            if (Objects.nonNull(salarioCltEscrita))
                salarioCltEscrita.setFuncionarioClt(funcionarioClt);
            if (Objects.nonNull(dependenteCltEscrita))
                dependenteCltEscrita.forEach(adicionaFuncionario -> adicionaFuncionario.setFuncionarioClt(funcionarioClt));
            if (Objects.nonNull(enderecosCltEscrita))
                enderecosCltEscrita.forEach(adicionaEndereco -> adicionaEndereco.setFuncionarioClt(funcionarioClt));
        }

        if (Objects.nonNull(salarioCltEscrita)) {
            Salario salario = salarioRepository.save(salarioCltEscrita);
            if (Objects.nonNull(auxilioAlimentacaoCltEscrita))
                auxilioAlimentacaoCltEscrita.setSalario(salario);
            if (Objects.nonNull(auxilioTransporteCltEscrita))
                auxilioTransporteCltEscrita.setSalario(salario);
        }

        if (Objects.nonNull(auxilioAlimentacaoCltEscrita)) auxilioAlimentacaoRepository.save(auxilioAlimentacaoCltEscrita);
        if (Objects.nonNull(auxilioTransporteCltEscrita)) auxilioTransporteRepository.save(auxilioTransporteCltEscrita);
        if (Objects.nonNull(dependenteCltEscrita)) dependenteRepositry.saveAll(dependenteCltEscrita);
        if (Objects.nonNull(enderecosCltEscrita)) enderecoRepository.saveAll(enderecosCltEscrita);

        if (Objects.nonNull(funcionarioEscrita.getFuncionarioCnpj())) {
            FuncionarioCnpj funcionarioCnpj = funcionarioCnpjRepository.save(funcionarioEscrita.getFuncionarioCnpj());
            if (Objects.nonNull(funcionarioEscrita.getFuncionarioCnpj().getSalario()))
                funcionarioEscrita.getFuncionarioCnpj().getSalario().setFuncionarioCnpj(funcionarioCnpj);
            if (Objects.nonNull(funcionarioEscrita.getFuncionarioCnpj().getDependentesList()))
                funcionarioEscrita.getFuncionarioCnpj().getDependentesList().forEach(adicionaFuncionario -> adicionaFuncionario.setFuncionarioCnpj(funcionarioCnpj));
            if (Objects.nonNull(funcionarioEscrita.getFuncionarioCnpj().getEndereco()))
                funcionarioEscrita.getFuncionarioCnpj().getEndereco().forEach(adicionaEndereco -> adicionaEndereco.setFuncionarioCnpj(funcionarioCnpj));
        }


        if (Objects.nonNull(funcionarioEscrita.getFuncionarioCnpj().getSalario())) {
            Salario salario = salarioRepository.save(funcionarioEscrita.getFuncionarioCnpj().getSalario());
            if (Objects.nonNull(funcionarioEscrita.getFuncionarioCnpj().getSalario().getAuxilioTransporte()))
                funcionarioEscrita.getFuncionarioCnpj().getSalario().getAuxilioTransporte().setSalario(salario);
            if (Objects.nonNull(funcionarioEscrita.getFuncionarioClt().getSalario().getAuxilioTransporte()))
                funcionarioEscrita.getFuncionarioCnpj().getSalario().getAuxilioTransporte().setSalario(salario);
        }

        if (Objects.nonNull(funcionarioEscrita.getFuncionarioCnpj().getSalario().getAuxilioAlimentacao()))
            auxilioAlimentacaoRepository.save(funcionarioEscrita.getFuncionarioCnpj().getSalario().getAuxilioAlimentacao());

        if (Objects.nonNull(funcionarioEscrita.getFuncionarioCnpj().getSalario().getAuxilioAlimentacao()))
            auxilioTransporteRepository.save(funcionarioEscrita.getFuncionarioCnpj().getSalario().getAuxilioTransporte());

        if (Objects.nonNull(funcionarioEscrita.getFuncionarioCnpj().getDependentesList()))
            dependenteRepositry.saveAll(funcionarioEscrita.getFuncionarioCnpj().getDependentesList());

        if (Objects.nonNull(funcionarioEscrita.getFuncionarioCnpj().getEndereco()))
            enderecoRepository.saveAll(funcionarioEscrita.getFuncionarioCnpj().getEndereco());

        FuncionarioRetornoDto funcionarioRetornoDto = escritaMapper.mapearFuncionarioDto(funcionarioEscrita);

        return funcionarioRetornoDto;
    }

    private Funcionario mapearFuncionarioTesT(Funcionario mapeamento) {

        Funcionario test = new Funcionario();

        test.setNumeroFuncionario(mapeamento.getNumeroFuncionario());
        test.setIdentificadorFuncionario(mapeamento.getIdentificadorFuncionario());
        test.setEstadoFuncionarioEnum(mapeamento.getEstadoFuncionarioEnum());

        return test;
    }

    public FuncionarioRetornoDto salvarSomenteFuncionario(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = this.mapearFuncionario(funcionarioDto);

        funcionario = funcionarioRepository.save(funcionario);

        FuncionarioRetornoDto funcionarioRetornoDto = this.mapearFuncionarioDto(funcionario);

        return funcionarioRetornoDto;
    }

    private FuncionarioRetornoDto mapearFuncionarioDto(Funcionario funcionario) {
        FuncionarioRetornoDto dto = new FuncionarioRetornoDto();

        dto.setIdentificadorFuncionario(funcionario.getIdentificadorFuncionario());
        dto.setNumeroFuncionario(funcionario.getNumeroFuncionario());
        dto.setEstadoFuncionarioEnum(funcionario.getEstadoFuncionarioEnum());

        return dto;
    }

    private Funcionario mapearFuncionario(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNumeroFuncionario(funcionarioDto.getNumeroFuncionario() != null ? funcionarioDto.getNumeroFuncionario() : NUMERO_DEFALT);
        funcionario.setIdentificadorFuncionario(String.valueOf(geradorUUID.getIdentificador()));
        funcionario.setEstadoFuncionarioEnum(EstadoFuncionarioEnum.ATIVO);

        return funcionario;
    }

}
