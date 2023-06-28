package br.com.funcionario.mapper;

import br.com.funcionario.domain.*;
import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.request.*;
import br.com.funcionario.dto.response.*;
import br.com.funcionario.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;

@Component
public class EscritaMapper {
    @Autowired
    private ConverteDate converteData;
    @Autowired
    private ConverteHora converteHora;
    @Autowired
    private GeradorUUID geradorUUID;
    @Autowired
    private FormataCpf formataCpf;
    @Autowired
    private FormataCnpj formataCnpj;
    @Autowired
    private FormataRg formataRg;
    @Autowired
    private FormataTelefone formataTelefone;
    @Autowired
    private FormataEndereco formataEndereco;
    @Autowired
    private ConverteValor converteValor;

    public Funcionario mapearFuncionario(FuncionarioDto funcionarioDto) throws ParseException {
        Funcionario funcionario = new Funcionario();
        Integer numeroFuncionario = this.geraNumero();
        funcionario.setIdentificadorFuncionario(String.valueOf(geradorUUID.getIdentificador()));
        funcionario.setEstadoFuncionarioEnum(funcionarioDto.getEstadoFuncionarioEnum() == null ? EstadoFuncionarioEnum.ATIVO : funcionarioDto.getEstadoFuncionarioEnum());
        funcionario.setNumeroFuncionario(numeroFuncionario);
        funcionario.setEstadoFuncionarioEnum(EstadoFuncionarioEnum.ATIVO);

        return funcionario;
    }

    public FuncionarioRetornoDto mapearFuncionarioDto(Funcionario funcionario) {
        FuncionarioRetornoDto funcionarioRetornoDto = new FuncionarioRetornoDto();

        funcionarioRetornoDto.setId(funcionario.getId());
        funcionarioRetornoDto.setIdentificadorFuncionario(funcionario.getIdentificadorFuncionario());
        funcionarioRetornoDto.setNumeroFuncionario(funcionario.getNumeroFuncionario());
        funcionarioRetornoDto.setEstadoFuncionarioEnum(funcionario.getEstadoFuncionarioEnum());
        funcionarioRetornoDto.setFuncionarioClt(this.mapearRetornoFuncionarioClt(funcionario.getFuncionarioClt()));
        funcionarioRetornoDto.setFuncionarioCnpj(this.mapearRetornoFuncionarioCnpj(funcionario.getFuncionarioCnpj()));

        return funcionarioRetornoDto;
    }

    public FuncionarioClt mapearEntradaFuncionaClt(FuncionarioCltDto funcionarioClt) throws ParseException {
        FuncionarioClt funcionario = new FuncionarioClt();

        if (Objects.nonNull(funcionarioClt)) {

            funcionario.setIdentificadorFuncionarioClt(String.valueOf(geradorUUID.getIdentificador()));
            funcionario.setFuncaoFuncionarioEnum(funcionarioClt.getFuncaoFuncionarioEnum());
            funcionario.setEstadoCivil(funcionarioClt.getEstadoCivil());
            funcionario.setNome(funcionarioClt.getNome().trim());
            funcionario.setDataNascimento(converteData.converterStringParaData(funcionarioClt.getDataNascimento()));
            funcionario.setCpf(this.formataCpf.formataCpf(funcionarioClt.getCpf()));
            funcionario.setRg(this.formataRg.formataRg(funcionarioClt.getRg()));
            funcionario.setDdd(funcionarioClt.getDdd().trim());
            funcionario.setTelefone(this.formataTelefone.formataTelefone(funcionarioClt.getTelefone()));
            funcionario.setEmail(funcionarioClt.getEmail().trim());
            funcionario.setDataAdmissao(new Date());
            funcionario.setHoraInicial(converteHora.converterStringParaHora(funcionarioClt.getHorarioInicial()));
            funcionario.setHoraFinal(converteHora.converterStringParaHora(funcionarioClt.getHorarioFinal()));
            funcionario.setAtivo(true);

            return funcionario;
        }

        return null;
    }

    private FuncionarioCltRetornoDto mapearRetornoFuncionarioClt(FuncionarioClt funcionarioClt) {
        FuncionarioCltRetornoDto funcionarioCltDto = new FuncionarioCltRetornoDto();

        if (Objects.nonNull(funcionarioClt)) {

            funcionarioCltDto.setIdentificadorFuncionarioClt(String.valueOf(funcionarioClt.getIdentificadorFuncionarioClt()));
            funcionarioCltDto.setFuncaoFuncionarioEnum(funcionarioClt.getFuncaoFuncionarioEnum());
            funcionarioCltDto.setEstadoCivil(funcionarioClt.getEstadoCivil());
            funcionarioCltDto.setSalario(this.montarRetornoSalario(funcionarioClt.getSalario()));
            funcionarioCltDto.setNome(funcionarioClt.getNome().trim());
            funcionarioCltDto.setDataNascimento(converteData.converterDateParaString(funcionarioClt.getDataNascimento()));
            funcionarioCltDto.setCpf(this.formataCpf.formataCpf(funcionarioClt.getCpf()));
            funcionarioCltDto.setRg(this.formataRg.formataRg(funcionarioClt.getRg()));
            funcionarioCltDto.setDdd(funcionarioClt.getDdd().trim());
            funcionarioCltDto.setTelefone(this.formataTelefone.formataTelefone(funcionarioClt.getTelefone()));
            funcionarioCltDto.setEmail(funcionarioClt.getEmail().trim());
            funcionarioCltDto.setDataAdmissao(new Date());
            funcionarioCltDto.setHoraInicial(funcionarioClt.getHoraInicial());
            funcionarioCltDto.setHoraFinal(funcionarioClt.getHoraFinal());
            funcionarioCltDto.setAtivo(funcionarioClt.getAtivo());
            funcionarioCltDto.setDependentesList(this.montarRetornoListaDependente(funcionarioClt.getDependentesList()));
            funcionarioCltDto.setEndereco(this.montarRetornoEndereco(funcionarioClt.getEndereco()));

            return funcionarioCltDto;
        }

        return null;
    }

    public FuncionarioCnpj mapearEntradaFuncionaCnpj(FuncionarioCnpjDto funcionarioCnpj) throws ParseException {
        FuncionarioCnpj funcionario = new FuncionarioCnpj();

        if (Objects.nonNull(funcionarioCnpj)) {
            funcionario.setIdentificadorFuncionarioCnpj(String.valueOf(geradorUUID.getIdentificador()));
            funcionario.setFuncaoFuncionarioEnum(funcionarioCnpj.getFuncaoFuncionarioEnum());
            funcionario.setEstadoCivil(funcionarioCnpj.getEstadoCivil());
            funcionario.setNome(funcionarioCnpj.getNome().trim());
            funcionario.setDataNascimento(converteData.converterStringParaData(funcionarioCnpj.getDataNascimento()));
            funcionario.setCpf(this.formataCpf.formataCpf(funcionarioCnpj.getCpf()));
            funcionario.setCnpj(this.formataCnpj.formataCnpj(funcionarioCnpj.getCnpj()));
            funcionario.setRg(this.formataRg.formataRg(funcionarioCnpj.getRg()));
            funcionario.setDdd(funcionarioCnpj.getDdd().trim());
            funcionario.setTelefone(this.formataCnpj.formataCnpj(funcionarioCnpj.getTelefone()));
            funcionario.setEmail(funcionarioCnpj.getEmail().trim());
            funcionario.setDataAdmissao(new Date());
            funcionario.setHoraInicial(converteHora.converterStringParaHora(funcionarioCnpj.getHorarioInicial()));
            funcionario.setHoraFinal(converteHora.converterStringParaHora(funcionarioCnpj.getHorarioFinal()));
            funcionario.setAtivo(true);

            return funcionario;
        }

        return null;
    }

    private FuncionarioCnpjRetornoDto mapearRetornoFuncionarioCnpj(FuncionarioCnpj funcionarioCnpj) {
        FuncionarioCnpjRetornoDto funcionarioCnpjDto = new FuncionarioCnpjRetornoDto();

        if (Objects.nonNull(funcionarioCnpj)) {
            funcionarioCnpjDto.setIdentificadorFuncionarioCnpj(funcionarioCnpj.getIdentificadorFuncionarioCnpj());
            funcionarioCnpjDto.setFuncaoFuncionarioEnum(funcionarioCnpj.getFuncaoFuncionarioEnum());
            funcionarioCnpjDto.setEstadoCivil(funcionarioCnpj.getEstadoCivil());
            funcionarioCnpjDto.setSalario(this.montarRetornoSalario(funcionarioCnpj.getSalario()));
            funcionarioCnpjDto.setNome(funcionarioCnpj.getNome().trim());
            funcionarioCnpjDto.setDataNascimento(funcionarioCnpj.getDataNascimento());
            funcionarioCnpjDto.setCpf(this.formataCpf.formataCpf(funcionarioCnpj.getCpf()));
            funcionarioCnpjDto.setCnpj(this.formataCnpj.formataCnpj(funcionarioCnpj.getCnpj()));
            funcionarioCnpjDto.setRg(this.formataRg.formataRg(funcionarioCnpj.getRg()));
            funcionarioCnpjDto.setDdd(funcionarioCnpj.getDdd().trim());
            funcionarioCnpjDto.setTelefone(this.formataTelefone.formataTelefone(funcionarioCnpj.getTelefone()));
            funcionarioCnpjDto.setEmail(funcionarioCnpj.getEmail().trim());
            funcionarioCnpjDto.setDataAdmissao(new Date());
            funcionarioCnpjDto.setHorarioInicial(funcionarioCnpj.getHoraInicial());
            funcionarioCnpjDto.setHorarioFinal(funcionarioCnpj.getHoraFinal());
            funcionarioCnpjDto.setAtivo(funcionarioCnpj.getAtivo());
            funcionarioCnpjDto.setDependentes(this.montarRetornoListaDependente(funcionarioCnpj.getDependentesList()));
            funcionarioCnpjDto.setEndereco(this.montarRetornoEndereco(funcionarioCnpj.getEndereco()));

            return funcionarioCnpjDto;
        }

        return null;
    }

    public List<Endereco> montarEntradaEndereco(List<EnderecoDto> enderecoDto) {
        List<Endereco> endereco = new ArrayList<>();

        if (Objects.nonNull(enderecoDto)) {

            Endereco enderecoRetornoDto = new Endereco();

            enderecoDto.forEach(e -> {
                enderecoRetornoDto.setIdentificadorEndereco(String.valueOf(geradorUUID.getIdentificador()));
                enderecoRetornoDto.setCep(this.formataEndereco.formataCep(e.getCep()));
                enderecoRetornoDto.setLogradouro(this.formataEndereco.formataLogradouro(e.getLogradouro()));
                enderecoRetornoDto.setNumero(this.formataEndereco.formataNumero(e.getNumero()));
                enderecoRetornoDto.setBairro(this.formataEndereco.formataBairro(e.getBairro()));
                enderecoRetornoDto.setCidade(this.formataEndereco.formataCidade(e.getCidade()));
                enderecoRetornoDto.setUf(this.formataEndereco.formataUf(e.getUf()));
                enderecoRetornoDto.setAtivo(true);
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
                enderecoRetornoDto.setCep(this.formataEndereco.formataCep(e.getCep()));
                enderecoRetornoDto.setLogradouro(this.formataEndereco.formataLogradouro(e.getLogradouro()));
                enderecoRetornoDto.setNumero(this.formataEndereco.formataNumero(e.getNumero()));
                enderecoRetornoDto.setBairro(this.formataEndereco.formataBairro(e.getBairro()));
                enderecoRetornoDto.setCidade(this.formataEndereco.formataCidade(e.getCidade()));
                enderecoRetornoDto.setUf(this.formataEndereco.formataUf(e.getUf()));
                enderecoDto.add(enderecoRetornoDto);
            });
        }

        return enderecoDto;
    }

    public List<Dependente> montarEntradaListaDependente(List<DependenteDto> dependentesList) throws ParseException {
        List<Dependente> dependete = new ArrayList<>();

        if (Objects.nonNull(dependentesList)) {

            Dependente dependenteRetornoDto = new Dependente();

            dependentesList.forEach(d -> {
                dependenteRetornoDto.setIdentificadorDependente(String.valueOf(geradorUUID.getIdentificador()));
                dependenteRetornoDto.setNome(d.getNome().trim());
                dependenteRetornoDto.setCpf(this.formataCpf.formataCpf(d.getCpf()));
                dependenteRetornoDto.setRg(this.formataRg.formataRg(d.getRg()));
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
                dependenteRetornoDto.setIdentificadorEndereco(d.getIdentificadorDependente());
                dependenteRetornoDto.setNome(d.getNome().trim());
                dependenteRetornoDto.setCpf(this.formataCpf.formataCpf(d.getCpf()));
                dependenteRetornoDto.setRg(this.formataRg.formataRg(d.getRg()));
                dependenteRetornoDto.setDataNascimento(d.getDataNascimento());
                dependenteRetornoDto.setGrauParentescoEnum(d.getGrauParentescoEnum());
                dependeteDto.add(dependenteRetornoDto);
            });
        }

        return dependeteDto;
    }


    public Salario montarEntradaSalario(SalarioDto salario) {
        Salario salarioRetornoDto = new Salario();

        if (Objects.nonNull(salario)) {

            salarioRetornoDto.setIdentificadorSalario(String.valueOf(geradorUUID.getIdentificador()));
            salarioRetornoDto.setSalario(converteValor.converteDoubleParaDecimal(salario.getSalario()));
            salarioRetornoDto.setValorAlimentacao(converteValor.converteDoubleParaDecimal(salario.getValorAlimentacao()));
            salarioRetornoDto.setTransporte(converteValor.converteDoubleParaDecimal(salario.getTransporte()));

            return salarioRetornoDto;
        }

        return null;
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

    public AuxilioTransporte montarEntradaAuxilioTransporte(AuxilioTransporteDto auxilioTransporteDto) {
        AuxilioTransporte auxilioTransporte = new AuxilioTransporte();

        if (Objects.nonNull(auxilioTransporteDto)) {

            auxilioTransporte.setIdentificadorAuxilioTransporte(String.valueOf(geradorUUID.getIdentificador()));
            auxilioTransporte.setDias(auxilioTransporteDto.getDias());
            auxilioTransporte.setValorPassagem(converteValor.converteDoubleParaDecimal(auxilioTransporteDto.getValorPassagem()));

        }

        return auxilioTransporte;
    }

    private AuxilioTransporteRetornoDto montarRetornoAuxilioTransporte(AuxilioTransporte auxilioTransporte) {
        AuxilioTransporteRetornoDto auxilioTransporteRetornoDto = new AuxilioTransporteRetornoDto();

        if (Objects.nonNull(auxilioTransporte)) {

            auxilioTransporteRetornoDto.setIdentificadorAuxilioTransporte(auxilioTransporte.getIdentificadorAuxilioTransporte());
            auxilioTransporteRetornoDto.setDias(auxilioTransporte.getDias());
            auxilioTransporteRetornoDto.setValorPassagem(converteValor.converteBigDecimalParaDouble(auxilioTransporte.getValorPassagem()));

        }

        return auxilioTransporteRetornoDto;
    }

    public AuxilioAlimentacao montarEntradaAuxilioAlimentacao(AuxilioAlimentacaoDto auxilioAlimentacaoDto) {
        AuxilioAlimentacao auxilioAlimentacao = new AuxilioAlimentacao();

        if (Objects.nonNull(auxilioAlimentacao)) {

            auxilioAlimentacao.setIdentificadorAuxilioAlimentacao(String.valueOf(geradorUUID.getIdentificador()));
            auxilioAlimentacao.setDias(auxilioAlimentacaoDto.getDias());
            auxilioAlimentacao.setValor(converteValor.converteDoubleParaDecimal(auxilioAlimentacaoDto.getValor()));

            return auxilioAlimentacao;
        }

        return null;
    }

    private AuxilioAlimentacaoRetornoDto montarRetornoAuxilioAlimentacao(AuxilioAlimentacao auxilioAlimentacao) {
        AuxilioAlimentacaoRetornoDto auxilioAlimentacaoRetornoDto = new AuxilioAlimentacaoRetornoDto();

        if (Objects.nonNull(auxilioAlimentacao)) {

            auxilioAlimentacaoRetornoDto.setIdentificadorAuxilioTransporte(auxilioAlimentacao.getIdentificadorAuxilioAlimentacao());
            auxilioAlimentacaoRetornoDto.setDias(auxilioAlimentacao.getDias());
            auxilioAlimentacaoRetornoDto.setValor(auxilioAlimentacao.getValor());

        }

        return auxilioAlimentacaoRetornoDto;
    }

    private Integer geraNumero() {
        Random random = new Random();
        return random.nextInt(101);
    }
}
