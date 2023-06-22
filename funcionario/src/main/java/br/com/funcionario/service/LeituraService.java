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
            List<Endereco> enderecosClt = enderecoRepository.findByFuncionarioClt((Long) funcionarioClt.get().getId());
            funcionarioClt.get().setEndereco(enderecosClt);
            List<Dependente> dependentesClt = dependenteRepositry.findByFuncinarioClt((Long) funcionarioClt.get().getId());
            funcionarioClt.get().setDependentesList(dependentesClt);
            Optional<Salario> salarioClt = salarioRepository.findByFuncionarioClt((Long) funcionarioClt.get().getId());
            Optional<AuxilioAlimentacao> auxilioAlimentacaoClt = auxilioAlimentacaoRepository.findBySalario((Long) salarioClt.get().getId());
            salarioClt.get().setAuxilioAlimentacao(this.mapearAuxilioAlimentacao(auxilioAlimentacaoClt));
            Optional<AuxilioTransporte> auxilioTransporteClt = auxilioTransporteRepository.findBySalario((Long) salarioClt.get().getId());
            salarioClt.get().setAuxilioTransporte(this.mapeiaAuxilioTransporte(auxilioTransporteClt));
            funcionarioClt.get().setSalario(salarioClt.get());
        }

        if (Objects.nonNull(funcionarioCnpj)) {
            List<Endereco> enderecosCnpj = enderecoRepository.findByFuncionarioCnpj((Long) funcionarioClt.get().getId());
            List<Dependente> dependentesCnpj = dependenteRepositry.findByFuncinarioCnpj((Long) funcionarioClt.get().getId());
            Optional<Salario> salarioCnpj = salarioRepository.findByFuncionarioCnpj((Long) funcionarioCnpj.get().getId());
            Optional<AuxilioAlimentacao> auxilioAlimentacaoCnpj = auxilioAlimentacaoRepository.findBySalario((Long) salarioCnpj.get().getId());
            Optional<AuxilioTransporte> auxilioTransporteCnpj = auxilioTransporteRepository.findBySalario((Long) salarioCnpj.get().getId());
        }


        funcionarioCompleRetornoDto = this.mapearFuncionario(funcionario);

        if (Objects.nonNull(funcionarioClt)) {
            FuncionarioCltRetornoDto funcionarioCltRetornoDto = new FuncionarioCltRetornoDto();
            funcionarioCltRetornoDto = this.mapearFuncionarioClt(funcionarioClt);
            funcionarioCompleRetornoDto.setFuncionarioClt(funcionarioCltRetornoDto);
        }

        if (Objects.nonNull(funcionarioCnpj)) {
            FuncionarioCnpjRetornoDto funcionarioCnpjRetornoDto = new FuncionarioCnpjRetornoDto();
            funcionarioCompleRetornoDto.setFuncionarioCnpj(this.mapearFuncionarioCnpj(funcionarioCnpj));
            funcionarioCompleRetornoDto.setFuncionarioCnpj(funcionarioCnpjRetornoDto);
        }

        return funcionarioCompleRetornoDto;
    }

    private AuxilioTransporte mapeiaAuxilioTransporte(Optional<AuxilioTransporte> auxilioTransporteClt) {

        AuxilioTransporte auxilioTransporte = new AuxilioTransporte();

        if(Objects.nonNull(auxilioTransporteClt)){

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

        if (Objects.nonNull( auxilioAlimentacao)){

            auxilioAlimentacao.setId(auxilioAlimentacaoClt.get().getId());
            auxilioAlimentacao.setIdentificadorAuxilioAlimentacao(auxilioAlimentacaoClt.get().getIdentificadorAuxilioAlimentacao());
            auxilioAlimentacao.setDias(auxilioAlimentacaoClt.get().getDias());
            auxilioAlimentacao.setValor(auxilioAlimentacaoClt.get().getValor());

            return  auxilioAlimentacao;
        }

        return null;
    }

    private FuncionarioCnpjRetornoDto mapearFuncionarioCnpj(Optional<FuncionarioCnpj> funcionarioCnpj) {

        FuncionarioCnpjRetornoDto funcionarioCnpjRetornoDto = new FuncionarioCnpjRetornoDto();

        return funcionarioCnpjRetornoDto;
    }

    private FuncionarioCltRetornoDto mapearFuncionarioClt(Optional<FuncionarioClt> funcionarioClt) {

        FuncionarioCltRetornoDto funcionarioCltRetornoDto = new FuncionarioCltRetornoDto();

        if (Objects.nonNull(funcionarioClt)) {

            funcionarioCltRetornoDto.setId(funcionarioClt.get().getId());
            funcionarioCltRetornoDto.setIdentificadorFuncionarioClt(funcionarioClt.get().getIdentificadorFuncionarioClt());
            funcionarioCltRetornoDto.setFuncaoFuncionarioEnum(funcionarioClt.get().getFuncaoFuncionarioEnum());
            funcionarioCltRetornoDto.setEstadoCivil(funcionarioClt.get().getEstadoCivil());
            funcionarioCltRetornoDto.setSalario(this.montarSalario(funcionarioClt.get().getSalario()));
            funcionarioCltRetornoDto.setNome(funcionarioClt.get().getNome());
            funcionarioCltRetornoDto.setDataNascimento(converteDate.converterDateParaString(funcionarioClt.get().getDataNascimento()));
            funcionarioCltRetornoDto.setCpf(funcionarioClt.get().getCpf());
            funcionarioCltRetornoDto.setRg(funcionarioClt.get().getRg());
            funcionarioCltRetornoDto.setDdd(funcionarioClt.get().getDdd());
            funcionarioCltRetornoDto.setTelefone(funcionarioClt.get().getTelefone());
            funcionarioCltRetornoDto.setEmail(funcionarioClt.get().getEmail());
            funcionarioCltRetornoDto.setDataAdmissao(funcionarioClt.get().getDataAdmissao());
            funcionarioCltRetornoDto.setHoraInicial(funcionarioClt.get().getHoraInicial());
            funcionarioCltRetornoDto.setHoraFinal(funcionarioClt.get().getHoraFinal());
            funcionarioCltRetornoDto.setAtivo(funcionarioClt.get().getAtivo());
            funcionarioCltRetornoDto.setEndereco(this.mapearEnderecoClt(funcionarioClt.get().getEndereco()));
            funcionarioCltRetornoDto.setDependentesList(this.mapearDependenteClt(funcionarioClt.get().getDependentesList()));

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
            salarioRetornoDto.setAuxilioAlimentacao(this.mapearAuxilioAlimentacaoDto(salario.getAuxilioAlimentacao()));
            salarioRetornoDto.setAuxilioTransporte(this.mapeiaAuxilioTransporteDto(salario.getAuxilioTransporte()));
        }

        return null;
    }

    private AuxilioTransporteRetornoDto mapeiaAuxilioTransporteDto(AuxilioTransporte auxilioTransporte) {

        AuxilioTransporteRetornoDto auxilioTransporteRetornoDto = new AuxilioTransporteRetornoDto();

        if (Objects.nonNull(auxilioTransporte)){

            auxilioTransporteRetornoDto.setIdentificadorAuxilioTransporte(auxilioTransporte.getIdentificadorAuxilioTransporte());
            auxilioTransporteRetornoDto.setDias(auxilioTransporte.getDias());
            auxilioTransporte.setValorPassagem(auxilioTransporte.getValorPassagem());

            return auxilioTransporteRetornoDto;
        }

        return null;
    }

    private AuxilioAlimentacaoRetornoDto mapearAuxilioAlimentacaoDto(AuxilioAlimentacao auxilioAlimentacao) {

        AuxilioAlimentacaoRetornoDto auxilioAlimentacaoRetornoDto = new AuxilioAlimentacaoRetornoDto();

        if (Objects.nonNull(auxilioAlimentacao)) {

            auxilioAlimentacaoRetornoDto.setIdentificadorAuxilioTransporte(auxilioAlimentacao.getIdentificadorAuxilioAlimentacao());
            auxilioAlimentacaoRetornoDto.setDias(auxilioAlimentacao.getDias());
            auxilioAlimentacaoRetornoDto.setValor(auxilioAlimentacao.getValor());

            return auxilioAlimentacaoRetornoDto;
        }

        return null;
    }

    private List<DependenteRetornoDto> mapearDependenteClt(List<Dependente> dependentesList) {

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

    private List<EnderecoRetornoDto> mapearEnderecoClt(List<Endereco> endereco) {

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
        }

        return funcionarioCompleRetornoDto;
    }
}
