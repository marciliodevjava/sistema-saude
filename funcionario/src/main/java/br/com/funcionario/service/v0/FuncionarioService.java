package br.com.funcionario.service.v0;

import br.com.funcionario.domain.*;
import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.NumeroDto;
import br.com.funcionario.dto.response.*;
import br.com.funcionario.http.GeradorClients;
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
import java.util.Objects;
import java.util.Random;

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
    @Autowired
    private GeradorClients geradorClients;


    @Override
    @Transient
    public FuncionarioRetornoDto salvarFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) throws ParseException {

        Funcionario funcionarioEscrita = escritaMapper.mapearFuncionario(funcionarioDto);

        Funcionario funcionario = funcionarioRepository.save(funcionarioEscrita);

        if (funcionarioDto.getInPrincipalFuncionarioClt().equals(true)) {
            FuncionarioClt funcionarioCltEscrita = escritaMapper.mapearEntradaFuncionaClt(funcionarioDto.getFuncionarioClt());
            Salario salarioCltEscrita = escritaMapper.montarEntradaSalario(funcionarioDto.getFuncionarioClt().getSalario());
            AuxilioAlimentacao auxilioAlimentacaoCltEscrita = escritaMapper.montarEntradaAuxilioAlimentacao(funcionarioDto.getFuncionarioClt().getSalario().getAuxilioAlimentacao());
            AuxilioTransporte auxilioTransporteCltEscrita = escritaMapper.montarEntradaAuxilioTransporte(funcionarioDto.getFuncionarioClt().getSalario().getAuxilioTransporte());
            List<Dependente> dependenteCltEscrita = escritaMapper.montarEntradaListaDependente(funcionarioDto.getFuncionarioClt().getDependentes());
            List<Endereco> enderecosCltEscrita = escritaMapper.montarEntradaEndereco(funcionarioDto.getFuncionarioClt().getEndereco());

            if (Objects.nonNull(funcionarioEscrita)) {
                if (Objects.nonNull(funcionarioCltEscrita)) {
                    funcionarioCltEscrita.setFuncionario(funcionario);
                    funcionario.setFuncionarioClt(funcionarioCltEscrita);
                }
            }

            if (Objects.nonNull(funcionarioCltEscrita)) {
                FuncionarioClt funcionarioClt = funcionarioCltRepository.save(funcionarioCltEscrita);
                if (Objects.nonNull(salarioCltEscrita)) {
                    salarioCltEscrita.setFuncionarioClt(funcionarioClt);
                    funcionarioCltEscrita.setSalario(salarioCltEscrita);
                }
                if (Objects.nonNull(dependenteCltEscrita)) {
                    dependenteCltEscrita.forEach(adicionaFuncionario -> adicionaFuncionario.setFuncionarioClt(funcionarioClt));
                    funcionarioCltEscrita.setDependentesList(dependenteCltEscrita);
                }
                if (Objects.nonNull(enderecosCltEscrita)) {
                    enderecosCltEscrita.forEach(adicionaEndereco -> adicionaEndereco.setFuncionarioClt(funcionarioClt));
                    funcionarioCltEscrita.setEndereco(enderecosCltEscrita);
                }
            }

            if (Objects.nonNull(salarioCltEscrita)) {
                Salario salarioClt = salarioRepository.save(salarioCltEscrita);
                if (Objects.nonNull(auxilioAlimentacaoCltEscrita)) {
                    auxilioAlimentacaoCltEscrita.setSalario(salarioClt);
                    salarioCltEscrita.setAuxilioAlimentacao(auxilioAlimentacaoCltEscrita);
                }
                if (Objects.nonNull(auxilioTransporteCltEscrita)) {
                    auxilioTransporteCltEscrita.setSalario(salarioClt);
                    salarioCltEscrita.setAuxilioTransporte(auxilioTransporteCltEscrita);
                }
            }

            if (Objects.nonNull(dependenteCltEscrita)) dependenteRepositry.saveAll(dependenteCltEscrita);

            if (Objects.nonNull(auxilioAlimentacaoCltEscrita))
                auxilioAlimentacaoRepository.save(auxilioAlimentacaoCltEscrita);

            if (Objects.nonNull(auxilioTransporteCltEscrita))
                auxilioTransporteRepository.save(auxilioTransporteCltEscrita);
            if (Objects.nonNull(enderecosCltEscrita)) enderecoRepository.saveAll(enderecosCltEscrita);
        }

        if (funcionarioDto.getInPrincipalFuncionarioCnpj().equals(true)) {
            FuncionarioCnpj funcionarioCnpjEscrita = escritaMapper.mapearEntradaFuncionaCnpj(funcionarioDto.getFuncionarioCnpj());
            Salario salarioCnpjEscrita = escritaMapper.montarEntradaSalario(funcionarioDto.getFuncionarioCnpj().getSalario());
            AuxilioAlimentacao auxilioAlimentacaoCnpjEscrita = escritaMapper.montarEntradaAuxilioAlimentacao(funcionarioDto.getFuncionarioCnpj().getSalario().getAuxilioAlimentacao());
            AuxilioTransporte auxilioTransporteCnpjEscrita = escritaMapper.montarEntradaAuxilioTransporte(funcionarioDto.getFuncionarioCnpj().getSalario().getAuxilioTransporte());
            List<Dependente> dependenteCnpjEscrita = escritaMapper.montarEntradaListaDependente(funcionarioDto.getFuncionarioCnpj().getDependentes());
            List<Endereco> enderecosCnpjEscrita = escritaMapper.montarEntradaEndereco(funcionarioDto.getFuncionarioCnpj().getEndereco());

            if (Objects.nonNull(funcionarioEscrita)) {
                if (Objects.nonNull(funcionarioCnpjEscrita)) {
                    funcionarioCnpjEscrita.setFuncionario(funcionario);
                    funcionario.setFuncionarioCnpj(funcionarioCnpjEscrita);
                }
            }

            if (Objects.nonNull(funcionarioCnpjEscrita)) {
                FuncionarioCnpj funcionarioCnpj = funcionarioCnpjRepository.save(funcionarioCnpjEscrita);
                if (Objects.nonNull(salarioCnpjEscrita)) {
                    salarioCnpjEscrita.setFuncionarioCnpj(funcionarioCnpj);
                    funcionarioCnpjEscrita.setSalario(salarioCnpjEscrita);
                }
                if (Objects.nonNull(dependenteCnpjEscrita)) {
                    dependenteCnpjEscrita.forEach(adicionaFuncionario -> adicionaFuncionario.setFuncionarioCnpj(funcionarioCnpj));
                    funcionarioCnpjEscrita.setDependentesList(dependenteCnpjEscrita);
                }
                if (Objects.nonNull(enderecosCnpjEscrita)) {
                    enderecosCnpjEscrita.forEach(adicionaEndereco -> adicionaEndereco.setFuncionarioCnpj(funcionarioCnpj));
                    funcionarioCnpjEscrita.setEndereco(enderecosCnpjEscrita);
                }
            }

            if (Objects.nonNull(salarioCnpjEscrita)) {
                Salario salario = salarioRepository.save(salarioCnpjEscrita);
                funcionarioCnpjEscrita.setSalario(salarioCnpjEscrita);
                if (Objects.nonNull(auxilioAlimentacaoCnpjEscrita)) {
                    auxilioAlimentacaoCnpjEscrita.setSalario(salario);
                    salarioCnpjEscrita.setAuxilioAlimentacao(auxilioAlimentacaoCnpjEscrita);
                }
                if (Objects.nonNull(auxilioTransporteCnpjEscrita)) {
                    auxilioTransporteCnpjEscrita.setSalario(salario);
                    salarioCnpjEscrita.setAuxilioTransporte(auxilioTransporteCnpjEscrita);
                }
            }

            if (Objects.nonNull(dependenteCnpjEscrita)) dependenteRepositry.saveAll(dependenteCnpjEscrita);
            if (Objects.nonNull(enderecosCnpjEscrita)) enderecoRepository.saveAll(enderecosCnpjEscrita);


            if (Objects.nonNull(auxilioTransporteCnpjEscrita))
                auxilioTransporteRepository.save(auxilioTransporteCnpjEscrita);
            if (Objects.nonNull(auxilioAlimentacaoCnpjEscrita))
                auxilioAlimentacaoRepository.save(auxilioAlimentacaoCnpjEscrita);
        }


        FuncionarioRetornoDto funcionarioRetornoDto = escritaMapper.mapearFuncionarioDto(funcionarioEscrita);

        return funcionarioRetornoDto;
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

        funcionario.setNumeroFuncionario(this.gerarNumero());
        funcionario.setIdentificadorFuncionario(String.valueOf(geradorUUID.getIdentificador()));
        funcionario.setEstadoFuncionarioEnum(EstadoFuncionarioEnum.ATIVO);
        funcionario.setInPrincipalFuncionarioClt(funcionarioDto.getInPrincipalFuncionarioClt());
        funcionario.setInPrincipalFuncionarioCnpj(funcionarioDto.getInPrincipalFuncionarioCnpj());

        return funcionario;
    }

    private Integer gerarNumero() {
        Random random = new Random();
        NumeroDto numero = new NumeroDto();
        numero.setNumero(random.nextInt(101));

        return numero.getNumero();
    }

    private Integer gerarNumeroIntegracao() {
        NumeroDto numero = geradorClients.geraFuncionario();

        return numero.getNumero();
    }

}
