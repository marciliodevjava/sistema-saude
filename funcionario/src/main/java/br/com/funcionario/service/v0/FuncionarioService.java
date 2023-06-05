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

        Funcionario mapeamento = escritaMapper.mapearFuncionario(funcionarioDto);

        if (Objects.nonNull(mapeamento)) {
            Funcionario funcionarioTest = this.mapearFuncionarioTesT(mapeamento);
            Funcionario funcionarioTes = funcionarioRepository.save(funcionarioTest);
            Funcionario funcionario = funcionarioRepository.save(mapeamento);
            if (Objects.nonNull(mapeamento.getFuncionarioClt()))
                mapeamento.getFuncionarioClt().setFuncionario(funcionario);
            if (Objects.nonNull(mapeamento.getFuncionarioCnpj()))
                mapeamento.getFuncionarioCnpj().setFuncionario(funcionario);
        }

        if (Objects.nonNull(mapeamento.getFuncionarioClt())) {
            FuncionarioClt funcionarioClt = funcionarioCltRepository.save(mapeamento.getFuncionarioClt());
            if (Objects.nonNull(mapeamento.getFuncionarioClt().getSalario()))
                mapeamento.getFuncionarioClt().getSalario().setFuncionarioClt(funcionarioClt);
            if (Objects.nonNull(mapeamento.getFuncionarioClt().getDependentesList()))
                mapeamento.getFuncionarioClt().getDependentesList().forEach(adicionaFuncionario -> adicionaFuncionario.setFuncionarioClt(funcionarioClt));
            if (Objects.nonNull(mapeamento.getFuncionarioClt().getEndereco()))
                mapeamento.getFuncionarioClt().getEndereco().forEach(adicionaEndereco -> adicionaEndereco.setFuncionarioClt(funcionarioClt));
        }

        if (Objects.nonNull(mapeamento.getFuncionarioClt().getSalario())) {
            Salario salario = salarioRepository.save(mapeamento.getFuncionarioClt().getSalario());
            if (Objects.nonNull(mapeamento.getFuncionarioClt().getSalario().getAuxilioTransporte()))
                mapeamento.getFuncionarioClt().getSalario().getAuxilioTransporte().setSalario(salario);
            if (Objects.nonNull(mapeamento.getFuncionarioClt().getSalario().getAuxilioTransporte()))
                mapeamento.getFuncionarioClt().getSalario().getAuxilioTransporte().setSalario(salario);
        }

        if (Objects.nonNull(mapeamento.getFuncionarioClt().getSalario().getAuxilioAlimentacao()))
            auxilioAlimentacaoRepository.save(mapeamento.getFuncionarioClt().getSalario().getAuxilioAlimentacao());

        if (Objects.nonNull(mapeamento.getFuncionarioClt().getSalario().getAuxilioTransporte()))
            auxilioTransporteRepository.save(mapeamento.getFuncionarioClt().getSalario().getAuxilioTransporte());

        if (Objects.nonNull(mapeamento.getFuncionarioClt().getDependentesList()))
            dependenteRepositry.saveAll(mapeamento.getFuncionarioClt().getDependentesList());

        if (Objects.nonNull(mapeamento.getFuncionarioClt().getEndereco()))
            enderecoRepository.saveAll(mapeamento.getFuncionarioClt().getEndereco());

        if (Objects.nonNull(mapeamento.getFuncionarioCnpj())) {
            FuncionarioCnpj funcionarioCnpj = funcionarioCnpjRepository.save(mapeamento.getFuncionarioCnpj());
            if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getSalario()))
                mapeamento.getFuncionarioCnpj().getSalario().setFuncionarioCnpj(funcionarioCnpj);
            if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getDependentesList()))
                mapeamento.getFuncionarioCnpj().getDependentesList().forEach(adicionaFuncionario -> adicionaFuncionario.setFuncionarioCnpj(funcionarioCnpj));
            if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getEndereco()))
                mapeamento.getFuncionarioCnpj().getEndereco().forEach(adicionaEndereco -> adicionaEndereco.setFuncionarioCnpj(funcionarioCnpj));
        }


        if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getSalario())) {
            Salario salario = salarioRepository.save(mapeamento.getFuncionarioCnpj().getSalario());
            if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getSalario().getAuxilioTransporte()))
                mapeamento.getFuncionarioCnpj().getSalario().getAuxilioTransporte().setSalario(salario);
            if (Objects.nonNull(mapeamento.getFuncionarioClt().getSalario().getAuxilioTransporte()))
                mapeamento.getFuncionarioCnpj().getSalario().getAuxilioTransporte().setSalario(salario);
        }

        if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getSalario().getAuxilioAlimentacao()))
            auxilioAlimentacaoRepository.save(mapeamento.getFuncionarioCnpj().getSalario().getAuxilioAlimentacao());

        if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getSalario().getAuxilioAlimentacao()))
            auxilioTransporteRepository.save(mapeamento.getFuncionarioCnpj().getSalario().getAuxilioTransporte());

        if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getDependentesList()))
            dependenteRepositry.saveAll(mapeamento.getFuncionarioCnpj().getDependentesList());

        if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getEndereco()))
            enderecoRepository.saveAll(mapeamento.getFuncionarioCnpj().getEndereco());

        FuncionarioRetornoDto funcionarioRetornoDto = escritaMapper.mapearFuncionarioDto(mapeamento);

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
