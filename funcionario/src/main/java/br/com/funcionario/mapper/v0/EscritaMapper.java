package br.com.funcionario.mapper.v0;

import br.com.funcionario.domain.*;
import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import br.com.funcionario.domain.utils.ConverteDate;
import br.com.funcionario.domain.utils.ConverteHora;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.request.*;
import br.com.funcionario.dto.response.*;
import br.com.funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class EscritaMapper {
    @Autowired
    private ConverteDate converteData;
    @Autowired
    private ConverteHora converteHora;

    public Funcionario mapearFuncionario(FuncionarioDto funcionarioDto) throws ParseException {
        Funcionario funcionario = new Funcionario();
        Integer numeroFuncionario = this.geraNumero();
        funcionario.setEstadoFuncionarioEnum(funcionarioDto.getEstadoFuncionarioEnum());
        funcionario.setNumeroFuncionario(numeroFuncionario);
        funcionario.setEstadoFuncionarioEnum(EstadoFuncionarioEnum.ATIVO);
        funcionario.setFuncionarioClt(this.mapearEntradaFuncionaClt(funcionarioDto.getFuncionarioClt()));
        funcionario.setFuncionarioCnpj(this.mapearEntradaFuncionaCnpj(funcionarioDto.getFuncionarioCnpj()));

        return funcionario;
    }

    public FuncionarioRetornoDto mapearFuncionarioDto(Funcionario funcionario) {
        FuncionarioRetornoDto funcionarioRetornoDto = new FuncionarioRetornoDto();

        funcionarioRetornoDto.setIdentificadorFuncionario(funcionario.getIdentificadorFuncionario());
        funcionarioRetornoDto.setNumeroFuncionario(this.geraNumero());
        funcionarioRetornoDto.setEstadoFuncionarioEnum(funcionario.getEstadoFuncionarioEnum());
        funcionarioRetornoDto.setFuncionarioClt(this.mapearRetornoFuncionarioClt(funcionario.getFuncionarioClt()));
        funcionarioRetornoDto.setFuncionarioCnpj(this.mapearRetornoFuncionarioCnpj(funcionario.getFuncionarioCnpj()));

        return funcionarioRetornoDto;
    }

    private FuncionarioClt mapearEntradaFuncionaClt(FuncionarioCltDto funcionarioClt) throws ParseException {
        FuncionarioClt funcionario = new FuncionarioClt();

        if (Objects.nonNull(funcionarioClt)) {

            funcionario.setFuncaoFuncionarioEnum(funcionarioClt.getFuncaoFuncionarioEnum());
            funcionario.setEstadoCivil(funcionarioClt.getEstadoCivil());
            funcionario.setSalario(this.montarEntradaSalario(funcionarioClt.getSalario()));
            funcionario.setNome(funcionarioClt.getNome());
            funcionario.setDataNascimento(converteData.converterStringParaData(funcionarioClt.getDataNascimento()));
            funcionario.setCpf(funcionarioClt.getCpf());
            funcionario.setRg(funcionarioClt.getRg());
            funcionario.setTelefone(funcionarioClt.getTelefone());
            funcionario.setEmail(funcionarioClt.getEmail());
            funcionario.setDataAdmissao(new Date());
            funcionario.setHoraInicial(converteHora.converterStringParaHora(funcionarioClt.getHorarioInicial()));
            funcionario.setHoraFinal(converteHora.converterStringParaHora(funcionarioClt.getHorarioFinal()));
            funcionario.setAtivo(true);
            funcionario.setDependentesList(this.montarEntradaListaDependente(funcionarioClt.getDependentesList()));
            funcionario.setEndereco(this.montarEntradaEndereco(funcionarioClt.getEndereco()));

        }

        return funcionario;
    }

    private FuncionarioCltRetornoDto mapearRetornoFuncionarioClt(FuncionarioClt funcionarioClt) {
        FuncionarioCltRetornoDto funcionarioCltDto = new FuncionarioCltRetornoDto();

        if (Objects.nonNull(funcionarioClt)) {

            funcionarioCltDto.setIdentificadorFuncionarioClt(funcionarioClt.getIdentificadorFuncionarioClt());
            funcionarioCltDto.setFuncaoFuncionarioEnum(funcionarioClt.getFuncaoFuncionarioEnum());
            funcionarioCltDto.setEstadoCivil(funcionarioClt.getEstadoCivil());
            funcionarioCltDto.setSalario(this.montarRetornoSalario(funcionarioClt.getSalario()));
            funcionarioCltDto.setNome(funcionarioClt.getNome());
            funcionarioCltDto.setDataNascimento(converteData.converterDateParaString(funcionarioClt.getDataNascimento()));
            funcionarioCltDto.setCpf(funcionarioClt.getCpf());
            funcionarioCltDto.setRg(funcionarioClt.getRg());
            funcionarioCltDto.setTelefone(funcionarioClt.getTelefone());
            funcionarioCltDto.setEmail(funcionarioClt.getEmail());
            funcionarioCltDto.setDataAdmissao(funcionarioClt.getDataAdmissao());
            funcionarioCltDto.setHoraInicial(funcionarioClt.getHoraInicial());
            funcionarioCltDto.setHoraFinal(funcionarioClt.getHoraFinal());
            funcionarioCltDto.setAtivo(funcionarioClt.getAtivo());
            funcionarioCltDto.setDependentesList(this.montarRetornoListaDependente(funcionarioClt.getDependentesList()));
            funcionarioCltDto.setEndereco(this.montarRetornoEndereco(funcionarioClt.getEndereco()));

        }

        return funcionarioCltDto;
    }

    private FuncionarioCnpj mapearEntradaFuncionaCnpj(FuncionarioCnpjDto funcionarioCnpj) throws ParseException {
        FuncionarioCnpj funcionario = new FuncionarioCnpj();

        if (Objects.nonNull(funcionarioCnpj)) {
            funcionario.setFuncaoFuncionarioEnum(funcionarioCnpj.getFuncaoFuncionarioEnum());
            funcionario.setEstadoCivil(funcionarioCnpj.getEstadoCivil());
            funcionario.setSalario(this.montarEntradaSalario(funcionarioCnpj.getSalario()));
            funcionario.setNome(funcionarioCnpj.getNome());
            funcionario.setDataNascimento(converteData.converterStringParaData(funcionarioCnpj.getDataNascimento()));
            funcionario.setCpf(funcionarioCnpj.getCpf());
            funcionario.setCnpj(funcionarioCnpj.getCnpj());
            funcionario.setRg(funcionarioCnpj.getRg());
            funcionario.setDdd(funcionarioCnpj.getDdd());
            funcionario.setTelefone(funcionarioCnpj.getTelefone());
            funcionario.setEmail(funcionarioCnpj.getEmail());
            funcionario.setDataAdmissao(new Date());
            funcionario.setHoraInicial(converteHora.converterStringParaHora(funcionarioCnpj.getHorarioInicial()));
            funcionario.setHoraFinal(converteHora.converterStringParaHora(funcionarioCnpj.getHorarioFinal()));
            funcionario.setAtivo(true);
            funcionario.setDependentesList(this.montarEntradaListaDependente(funcionarioCnpj.getDependentesList()));
            funcionario.setEndereco(this.montarEntradaEndereco(funcionarioCnpj.getEndereco()));

            return funcionario;
        }

        return funcionario;
    }

    private FuncionarioCnpjRetornoDto mapearRetornoFuncionarioCnpj(FuncionarioCnpj funcionarioCnpj) {
        FuncionarioCnpjRetornoDto funcionarioCnpjDto = new FuncionarioCnpjRetornoDto();

        if (Objects.nonNull(funcionarioCnpj)) {
            funcionarioCnpjDto.setIdentificadorFuncionarioCnpj(funcionarioCnpj.getIdentificadorFuncionarioCnpj());
            funcionarioCnpjDto.setFuncaoFuncionarioEnum(funcionarioCnpj.getFuncaoFuncionarioEnum());
            funcionarioCnpjDto.setEstadoCivil(funcionarioCnpj.getEstadoCivil());
            funcionarioCnpjDto.setSalario(this.montarRetornoSalario(funcionarioCnpj.getSalario()));
            funcionarioCnpjDto.setNome(funcionarioCnpj.getNome());
            funcionarioCnpjDto.setDataNascimento(converteData.converterDateParaString(funcionarioCnpj.getDataNascimento()));
            funcionarioCnpjDto.setCpf(funcionarioCnpj.getCpf());
            funcionarioCnpjDto.setCnpj(funcionarioCnpj.getCnpj());
            funcionarioCnpjDto.setRg(funcionarioCnpj.getRg());
            funcionarioCnpjDto.setDdd(funcionarioCnpj.getDdd());
            funcionarioCnpjDto.setTelefone(funcionarioCnpj.getTelefone());
            funcionarioCnpjDto.setEmail(funcionarioCnpj.getEmail());
            funcionarioCnpjDto.setDataAdmissao(funcionarioCnpj.getDataAdmissao());
            funcionarioCnpjDto.setHorarioInicial(funcionarioCnpj.getHoraInicial());
            funcionarioCnpjDto.setHorarioFinal(funcionarioCnpj.getHoraFinal());
            funcionarioCnpjDto.setAtivo(funcionarioCnpj.getAtivo());
            funcionarioCnpjDto.setDependentes(this.montarRetornoListaDependente(funcionarioCnpj.getDependentesList()));
            funcionarioCnpjDto.setEndereco(this.montarRetornoEndereco(funcionarioCnpj.getEndereco()));

            return funcionarioCnpjDto;
        }

        return funcionarioCnpjDto;
    }

    private List<Endereco> montarEntradaEndereco(List<EnderecoDto> enderecoDto) {
        List<Endereco> endereco = new ArrayList<>();

        if (Objects.nonNull(enderecoDto)) {

            Endereco enderecoRetornoDto = new Endereco();

            enderecoDto.forEach(e -> {
                enderecoRetornoDto.setCep(e.getCep());
                enderecoRetornoDto.setLogradouro(e.getLogradouro());
                enderecoRetornoDto.setNumero(e.getNumero());
                enderecoRetornoDto.setBairro(e.getBairro());
                enderecoRetornoDto.setCidade(e.getCidade());
                enderecoRetornoDto.setUf(e.getUf());
                endereco.add(enderecoRetornoDto);
            });
        }

        return endereco;
    }

    private List<EnderecoRetornoDto> montarRetornoEndereco(List<Endereco> endereco) {
        List<EnderecoRetornoDto> enderecoDto = new ArrayList<>();

        if (Objects.nonNull(endereco)) {

            EnderecoRetornoDto enderecoRetornoDto = new EnderecoRetornoDto();

            endereco.forEach(e -> {
                enderecoRetornoDto.setIdentificadorEndereco(e.getIdentificadorEndereco());
                enderecoRetornoDto.setCep(e.getCep());
                enderecoRetornoDto.setLogradouro(e.getLogradouro());
                enderecoRetornoDto.setNumero(e.getNumero());
                enderecoRetornoDto.setBairro(e.getBairro());
                enderecoRetornoDto.setCidade(e.getCidade());
                enderecoRetornoDto.setUf(e.getUf());
                enderecoDto.add(enderecoRetornoDto);
            });
        }

        return enderecoDto;
    }

    private List<Dependente> montarEntradaListaDependente(List<DependenteDto> dependentesList) throws ParseException {
        List<Dependente> dependete = new ArrayList<>();

        if (Objects.nonNull(dependentesList)) {

            Dependente dependenteRetornoDto = new Dependente();

            dependentesList.forEach(d -> {
                dependenteRetornoDto.setNome(d.getNome());
                dependenteRetornoDto.setCpf(d.getCpf());
                dependenteRetornoDto.setRg(d.getRg());
                try {
                    dependenteRetornoDto.setDataNascimento(converteData.converterStringParaData(d.getDataNascimento()));
                } catch (ParseException e) {
                    throw new RuntimeException("Data de nascimento está vázia.");
                }
                dependenteRetornoDto.setGrauParentescoEnum(d.getGrauParentescoEnum());
                dependete.add(dependenteRetornoDto);
            });
        }

        return dependete;
    }

    private List<DependenteRetornoDto> montarRetornoListaDependente(List<Dependente> dependente) {
        List<DependenteRetornoDto> dependeteDto = new ArrayList<>();

        if (Objects.nonNull(dependente)) {

            DependenteRetornoDto dependenteRetornoDto = new DependenteRetornoDto();

            dependente.forEach(d -> {
                dependenteRetornoDto.setIdentificadorEndereco(d.getIdentificadorEndereco());
                dependenteRetornoDto.setNome(d.getNome());
                dependenteRetornoDto.setCpf(d.getCpf());
                dependenteRetornoDto.setRg(d.getRg());
                dependenteRetornoDto.setDataNascimento(d.getDataNascimento());
                dependenteRetornoDto.setGrauParentescoEnum(d.getGrauParentescoEnum());
                dependeteDto.add(dependenteRetornoDto);
            });
        }

        return dependeteDto;
    }


    private Salario montarEntradaSalario(SalarioDto salario) {
        Salario salarioRetornoDto = new Salario();

        if (Objects.nonNull(salario)) {

            salarioRetornoDto.setSalario(salario.getSalario());
            salarioRetornoDto.setValorAlimentacao(salario.getValorAlimentacao());
            salarioRetornoDto.setTransporte(salario.getTransporte());
            salarioRetornoDto.setAuxilioAlimentacao(this.montarEntradaAuxilioAlimentacao(salario.getAuxilioAlimentacao()));
            salarioRetornoDto.setAuxilioTransporte(this.montarEntradaAuxilioTransporte(salario.getAuxilioTransporte()));

        }

        return salarioRetornoDto;
    }

    private SalarioRetornoDto montarRetornoSalario(Salario salario) {
        SalarioRetornoDto salarioRetornoDto = new SalarioRetornoDto();

        if (Objects.nonNull(salario)) {

            salarioRetornoDto.setIdentificadorSalario(salario.getIdentificadorSalario());
            salarioRetornoDto.setSalario(salario.getSalario());
            salarioRetornoDto.setValorAlimentacao(salario.getValorAlimentacao());
            salarioRetornoDto.setTransporte(salario.getTransporte());
            salarioRetornoDto.setAuxilioAlimentacao(this.montarRetornoAuxilioAlimentacao(salario.getAuxilioAlimentacao()));
            salarioRetornoDto.setAuxilioTransporte(this.montarRetornoAuxilioTransporte(salario.getAuxilioTransporte()));

        }

        return salarioRetornoDto;
    }

    private AuxilioTransporte montarEntradaAuxilioTransporte(AuxilioTransporteDto auxilioTransporteDto) {
        AuxilioTransporte auxilioTransporte = new AuxilioTransporte();

        if (Objects.nonNull(auxilioTransporteDto)) {

            auxilioTransporte.setDias(auxilioTransporteDto.getDias());
            auxilioTransporte.setValorPassagem(auxilioTransporteDto.getValorPassagem());

        }

        return auxilioTransporte;
    }

    private AuxilioTransporteRetornoDto montarRetornoAuxilioTransporte(AuxilioTransporte auxilioTransporte) {
        AuxilioTransporteRetornoDto auxilioTransporteRetornoDto = new AuxilioTransporteRetornoDto();

        if (Objects.nonNull(auxilioTransporte)) {

            auxilioTransporteRetornoDto.setIdentificadorAuxilioTransporte(auxilioTransporte.getIdentificadorAuxilioTransporte());
            auxilioTransporteRetornoDto.setDias(auxilioTransporte.getDias());
            auxilioTransporteRetornoDto.setValorPassagem(auxilioTransporte.getValorPassagem());

        }

        return auxilioTransporteRetornoDto;
    }

    private AuxilioAlimentacao montarEntradaAuxilioAlimentacao(AuxilioAlimentacaoDto auxilioAlimentacaoDto) {
        AuxilioAlimentacao auxilioAlimentacao = new AuxilioAlimentacao();

        if (Objects.nonNull(auxilioAlimentacao)) {

            auxilioAlimentacao.setIdentificadorAuxilioTransporte(auxilioAlimentacao.getIdentificadorAuxilioTransporte());
            auxilioAlimentacao.setDias(auxilioAlimentacao.getDias());
            auxilioAlimentacao.setValor(auxilioAlimentacao.getValor());

        }

        return auxilioAlimentacao;
    }

    private AuxilioAlimentacaoRetornoDto montarRetornoAuxilioAlimentacao(AuxilioAlimentacao auxilioAlimentacao) {
        AuxilioAlimentacaoRetornoDto auxilioAlimentacaoRetornoDto = new AuxilioAlimentacaoRetornoDto();

        if (Objects.nonNull(auxilioAlimentacao)) {

            auxilioAlimentacaoRetornoDto.setIdentificadorAuxilioTransporte(auxilioAlimentacao.getIdentificadorAuxilioTransporte());
            auxilioAlimentacaoRetornoDto.setDias(auxilioAlimentacao.getDias());
            auxilioAlimentacaoRetornoDto.setValor(auxilioAlimentacao.getValor());

        }

        return auxilioAlimentacaoRetornoDto;
    }

    private Integer geraNumero() {

        return 0;
    }
}
