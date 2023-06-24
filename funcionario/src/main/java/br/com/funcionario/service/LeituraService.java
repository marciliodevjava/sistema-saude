package br.com.funcionario.service;

import br.com.funcionario.domain.*;
import br.com.funcionario.dto.response.*;
import br.com.funcionario.repository.*;
import br.com.funcionario.utils.ConverteDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LeituraService {

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
    private ConverteDate converteDate;

    public FuncionarioCompleRetornoDto funcionarioCompleto(Long id) {
        FuncionarioCompleRetornoDto funcionarioCompleRetornoDto = new FuncionarioCompleRetornoDto();

        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        Optional<FuncionarioClt> funcionarioClt = funcionarioCltRepository.findByFuncionario((Long) funcionario.get().getId());
        Optional<FuncionarioCnpj> funcionarioCnpj = funcionarioCnpjRepository.findByFuncionario((Long) funcionario.get().getId());

        if (Objects.nonNull(funcionarioClt)) {
            List<Endereco> enderecosClt = enderecoRepository.findByFuncionarioClt(funcionarioClt.get().getId());
            funcionarioClt.get().setEndereco(enderecosClt);
            List<Dependente> dependentesClt = dependenteRepositry.findByFuncionarioClt(funcionarioClt.get().getId());
            funcionarioClt.get().setDependentesList(dependentesClt);
            Optional<Salario> salarioClt = salarioRepository.findByFuncionarioClt((Long) funcionarioClt.get().getId());
            Optional<AuxilioAlimentacao> auxilioAlimentacaoClt = auxilioAlimentacaoRepository.findBySalario((Long) salarioClt.get().getId());
            salarioClt.get().setAuxilioAlimentacao(this.mapearAuxilioAlimentacao(auxilioAlimentacaoClt));
            Optional<AuxilioTransporte> auxilioTransporteClt = auxilioTransporteRepository.findBySalario((Long) salarioClt.get().getId());
            salarioClt.get().setAuxilioTransporte(this.mapeiaAuxilioTransporte(auxilioTransporteClt));
            funcionarioClt.get().setSalario(salarioClt.get());
        }

        if (Objects.nonNull(funcionarioCnpj)) {
            List<Endereco> enderecosCnpj = enderecoRepository.findByFuncionarioCnpj(funcionarioClt.get().getId());
            funcionarioCnpj.get().setEndereco(enderecosCnpj);
            List<Dependente> dependentesCnpj = dependenteRepositry.findByFuncionarioCnpj(funcionarioCnpj.get().getId());
            funcionarioCnpj.get().setDependentesList(dependentesCnpj);
            Optional<Salario> salarioCnpj = salarioRepository.findByFuncionarioCnpj((Long) funcionarioCnpj.get().getId());
            Optional<AuxilioAlimentacao> auxilioAlimentacaoCnpj = auxilioAlimentacaoRepository.findBySalario((Long) salarioCnpj.get().getId());
            salarioCnpj.get().setAuxilioAlimentacao(this.mapearAuxilioAlimentacao(auxilioAlimentacaoCnpj));
            Optional<AuxilioTransporte> auxilioTransporteCnpj = auxilioTransporteRepository.findBySalario((Long) salarioCnpj.get().getId());
            salarioCnpj.get().setAuxilioTransporte(this.mapeiaAuxilioTransporte(auxilioTransporteCnpj));
            funcionarioCnpj.get().setSalario(salarioCnpj.get());
        }


        funcionarioCompleRetornoDto = this.mapearFuncionario(funcionario);

        if (Objects.nonNull(funcionarioClt)) {
            FuncionarioCltRetornoDto funcionarioCltRetornoDto;
            funcionarioCltRetornoDto = this.mapearFuncionarioClt(funcionarioClt);
            funcionarioCompleRetornoDto.setFuncionarioClt(funcionarioCltRetornoDto);
        }

        if (Objects.nonNull(funcionarioCnpj)) {
            FuncionarioCnpjRetornoDto funcionarioCnpjRetornoDto;
            funcionarioCnpjRetornoDto = this.mapearFuncionarioCnpj(funcionarioCnpj);
            funcionarioCompleRetornoDto.setFuncionarioCnpj(funcionarioCnpjRetornoDto);
        }

        return funcionarioCompleRetornoDto;
    }

    private FuncionarioCnpjRetornoDto mapearFuncionarioCnpj(Optional<FuncionarioCnpj> funcionarioCnpj1) {

        FuncionarioCnpjRetornoDto funcionarioCnpjRetornoDto = new FuncionarioCnpjRetornoDto();

        if (Objects.nonNull(funcionarioCnpj1)) {

            FuncionarioCnpj funcionarioCnpj = funcionarioCnpj1.get();

            funcionarioCnpjRetornoDto.setIdentificadorFuncionarioCnpj(funcionarioCnpj.getIdentificadorFuncionarioCnpj());
            funcionarioCnpjRetornoDto.setFuncaoFuncionarioEnum(funcionarioCnpj.getFuncaoFuncionarioEnum());
            funcionarioCnpjRetornoDto.setEstadoCivil(funcionarioCnpj.getEstadoCivil());
            funcionarioCnpjRetornoDto.setSalario(this.montarSalario(funcionarioCnpj.getSalario()));
            funcionarioCnpjRetornoDto.setNome(funcionarioCnpj.getNome());
            funcionarioCnpjRetornoDto.setDataAdmissao(funcionarioCnpj.getDataAdmissao());
            funcionarioCnpjRetornoDto.setCpf(funcionarioCnpj.getCpf());
            funcionarioCnpjRetornoDto.setCnpj(funcionarioCnpj.getCnpj());
            funcionarioCnpjRetornoDto.setRg(funcionarioCnpj.getRg());
            funcionarioCnpjRetornoDto.setDdd(funcionarioCnpj.getDdd());
            funcionarioCnpjRetornoDto.setTelefone(funcionarioCnpj.getTelefone());
            funcionarioCnpjRetornoDto.setEmail(funcionarioCnpj.getEmail());
            funcionarioCnpjRetornoDto.setDataAdmissao(funcionarioCnpj.getDataAdmissao());
            funcionarioCnpjRetornoDto.setHorarioInicial(funcionarioCnpj.getHoraInicial());
            funcionarioCnpjRetornoDto.setHorarioFinal(funcionarioCnpj.getHoraFinal());
            funcionarioCnpjRetornoDto.setAtivo(funcionarioCnpj.getAtivo());
            funcionarioCnpjRetornoDto.setDependentes(this.mapearDependente(funcionarioCnpj.getDependentesList()));
            funcionarioCnpjRetornoDto.setEndereco(this.mapearEndereco(funcionarioCnpj.getEndereco()));

            return funcionarioCnpjRetornoDto;
        }

        return null;
    }

    private FuncionarioCltRetornoDto mapearFuncionarioClt(Optional<FuncionarioClt> funcionarioClt1) {

        FuncionarioCltRetornoDto funcionarioCltRetornoDto = new FuncionarioCltRetornoDto();

        if (Objects.nonNull(funcionarioClt1)) {

            FuncionarioClt funcionarioClt = funcionarioClt1.get();

            funcionarioCltRetornoDto.setIdentificadorFuncionarioClt(funcionarioClt.getIdentificadorFuncionarioClt());
            funcionarioCltRetornoDto.setFuncaoFuncionarioEnum(funcionarioClt.getFuncaoFuncionarioEnum());
            funcionarioCltRetornoDto.setEstadoCivil(funcionarioClt.getEstadoCivil());
            funcionarioCltRetornoDto.setSalario(this.montarSalario(funcionarioClt.getSalario()));
            funcionarioCltRetornoDto.setNome(funcionarioClt.getNome());
            funcionarioCltRetornoDto.setDataNascimento(converteDate.converterDateParaString(funcionarioClt.getDataNascimento()));
            funcionarioCltRetornoDto.setCpf(funcionarioClt.getCpf());
            funcionarioCltRetornoDto.setRg(funcionarioClt.getRg());
            funcionarioCltRetornoDto.setDdd(funcionarioClt.getDdd());
            funcionarioCltRetornoDto.setTelefone(funcionarioClt.getTelefone());
            funcionarioCltRetornoDto.setEmail(funcionarioClt.getEmail());
            funcionarioCltRetornoDto.setDataAdmissao(funcionarioClt.getDataAdmissao());
            funcionarioCltRetornoDto.setHoraInicial(funcionarioClt.getHoraInicial());
            funcionarioCltRetornoDto.setHoraFinal(funcionarioClt.getHoraFinal());
            funcionarioCltRetornoDto.setAtivo(funcionarioClt.getAtivo());
            funcionarioCltRetornoDto.setEndereco(this.mapearEndereco(funcionarioClt.getEndereco()));
            funcionarioCltRetornoDto.setDependentesList(this.mapearDependente(funcionarioClt.getDependentesList()));

            return funcionarioCltRetornoDto;
        }

        return null;
    }

    private SalarioRetornoDto montarSalario(Salario salario) {

        SalarioRetornoDto salarioRetornoDto = new SalarioRetornoDto();

        if (Objects.nonNull(salario)) {

            salarioRetornoDto.setIdentificadorSalario(salario.getIdentificadorSalario());
            salarioRetornoDto.setSalario(salario.getSalario());
            salarioRetornoDto.setValorAlimentacao(salario.getValorAlimentacao());
            salarioRetornoDto.setTransporte(salario.getTransporte());
            salarioRetornoDto.setAuxilioAlimentacao(this.mapearAuxilioAlimentacao(salario.getAuxilioAlimentacao()));
            salarioRetornoDto.setAuxilioTransporte(this.mapeiaAuxilioTransporte(salario.getAuxilioTransporte()));

            return salarioRetornoDto;
        }

        return null;
    }

    private AuxilioTransporteRetornoDto mapeiaAuxilioTransporte(AuxilioTransporte auxilioTransporte) {

        AuxilioTransporteRetornoDto auxilioTransporteRetornoDto = new AuxilioTransporteRetornoDto();

        if (Objects.nonNull(auxilioTransporte)) {

            auxilioTransporteRetornoDto.setIdentificadorAuxilioTransporte(auxilioTransporte.getIdentificadorAuxilioTransporte());
            auxilioTransporteRetornoDto.setDias(auxilioTransporte.getDias());
            auxilioTransporte.setValorPassagem(auxilioTransporte.getValorPassagem());

            return auxilioTransporteRetornoDto;
        }

        return null;
    }

    private AuxilioAlimentacaoRetornoDto mapearAuxilioAlimentacao(AuxilioAlimentacao auxilioAlimentacao) {

        AuxilioAlimentacaoRetornoDto auxilioAlimentacaoRetornoDto = new AuxilioAlimentacaoRetornoDto();

        if (Objects.nonNull(auxilioAlimentacao)) {

            auxilioAlimentacaoRetornoDto.setIdentificadorAuxilioTransporte(auxilioAlimentacao.getIdentificadorAuxilioAlimentacao());
            auxilioAlimentacaoRetornoDto.setDias(auxilioAlimentacao.getDias());
            auxilioAlimentacaoRetornoDto.setValor(auxilioAlimentacao.getValor());

            return auxilioAlimentacaoRetornoDto;
        }

        return null;
    }

    private List<DependenteRetornoDto> mapearDependente(List<Dependente> dependentesList) {

        List<DependenteRetornoDto> dependenteRetorno = new ArrayList<>();

        if (Objects.nonNull(dependentesList)) {
            dependentesList.forEach(e -> {

                DependenteRetornoDto dependenteRetornoDto = new DependenteRetornoDto();

                dependenteRetornoDto.setIdentificadorEndereco(e.getIdentificadorDependente());
                dependenteRetornoDto.setNome(e.getNome());
                dependenteRetornoDto.setCpf(e.getCpf());
                dependenteRetornoDto.setRg(e.getRg());
                dependenteRetornoDto.setDataNascimento(e.getDataNascimento());
                dependenteRetornoDto.setGrauParentescoEnum(e.getGrauParentescoEnum());

                dependenteRetorno.add(dependenteRetornoDto);
            });

            return dependenteRetorno;
        }

        return Collections.emptyList();
    }

    private List<EnderecoRetornoDto> mapearEndereco(List<Endereco> endereco) {

        List<EnderecoRetornoDto> enderecoRetorno = new ArrayList<>();

        if (Objects.nonNull(endereco)) {
            endereco.forEach(e -> {

                EnderecoRetornoDto enderecoRetornoDto = new EnderecoRetornoDto();

                enderecoRetornoDto.setIdentificadorEndereco(e.getIdentificadorEndereco());
                enderecoRetornoDto.setCep(e.getCep());
                enderecoRetornoDto.setLogradouro(e.getLogradouro());
                enderecoRetornoDto.setNumero(e.getNumero());
                enderecoRetornoDto.setBairro(e.getBairro());
                enderecoRetornoDto.setCidade(e.getCidade());
                enderecoRetornoDto.setUf(e.getUf());

                enderecoRetorno.add(enderecoRetornoDto);
            });

            return enderecoRetorno;
        }

        return Collections.emptyList();
    }

    private FuncionarioCompleRetornoDto mapearFuncionario(Optional<Funcionario> funcionario) {
        FuncionarioCompleRetornoDto funcionarioCompleRetornoDto = new FuncionarioCompleRetornoDto();
        if (Objects.nonNull(funcionario)) {

            funcionarioCompleRetornoDto.setIdentificadorFunciona(funcionario.get().getIdentificadorFuncionario());
            funcionarioCompleRetornoDto.setMatricula(funcionario.get().getNumeroFuncionario());

            return funcionarioCompleRetornoDto;
        }

        return null;
    }


    private AuxilioTransporte mapeiaAuxilioTransporte(Optional<AuxilioTransporte> auxilioTransporteClt) {

        AuxilioTransporte auxilioTransporte = new AuxilioTransporte();

        if (Objects.nonNull(auxilioTransporteClt)) {

            auxilioTransporte.setId(auxilioTransporteClt.get().getId());
            auxilioTransporte.setIdentificadorAuxilioTransporte(auxilioTransporteClt.get().getIdentificadorAuxilioTransporte());
            auxilioTransporte.setDias(auxilioTransporteClt.get().getDias());
            auxilioTransporte.setValorPassagem(auxilioTransporteClt.get().getValorPassagem());

            return auxilioTransporte;
        }

        return null;
    }

    private AuxilioAlimentacao mapearAuxilioAlimentacao(Optional<AuxilioAlimentacao> auxilioAlimentacaoClt) {

        AuxilioAlimentacao auxilioAlimentacao = new AuxilioAlimentacao();

        if (Objects.nonNull(auxilioAlimentacao)) {

            auxilioAlimentacao.setId(auxilioAlimentacaoClt.get().getId());
            auxilioAlimentacao.setIdentificadorAuxilioAlimentacao(auxilioAlimentacaoClt.get().getIdentificadorAuxilioAlimentacao());
            auxilioAlimentacao.setDias(auxilioAlimentacaoClt.get().getDias());
            auxilioAlimentacao.setValor(auxilioAlimentacaoClt.get().getValor());

            return auxilioAlimentacao;
        }

        return null;
    }
}
