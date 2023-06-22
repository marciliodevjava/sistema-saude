package br.com.funcionario.service;

import br.com.funcionario.domain.*;
import br.com.funcionario.dto.response.AuxilioAlimentacaoRetornoDto;
import br.com.funcionario.dto.response.FuncionarioCltRetornoDto;
import br.com.funcionario.dto.response.FuncionarioCnpjRetornoDto;
import br.com.funcionario.dto.response.FuncionarioCompleRetornoDto;
import br.com.funcionario.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public FuncionarioCompleRetornoDto funcionarioCompleto(Long id) {
        FuncionarioCompleRetornoDto funcionarioCompleRetornoDto = new FuncionarioCompleRetornoDto();

        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        Optional<FuncionarioClt> funcionarioClt = funcionarioCltRepository.findByFuncionario((Long) funcionario.get().getId());
        Optional<FuncionarioCnpj> funcionarioCnpj = funcionarioCnpjRepository.findByFuncionario((Long) funcionario.get().getId());

        if(Objects.nonNull(funcionarioClt)){
            List<Endereco> enderecosClt = enderecoRepository.findByFuncionarioClt((Long) funcionarioClt.get().getId());
            List<Dependente> dependentesClt = dependenteRepositry.findByFuncinarioClt((Long) funcionarioClt.get().getId());
            Optional<Salario> salarioClt = salarioRepository.findByFuncionarioClt((Long) funcionarioClt.get().getId());
            Optional<AuxilioAlimentacao> auxilioAlimentacaoClt = auxilioAlimentacaoRepository.findBySalario((Long) salarioClt.get().getId());
            Optional<AuxilioTransporte> auxilioTransporteClt = auxilioTransporteRepository.findBySalario((Long) salarioClt.get().getId());
        }

        if (Objects.nonNull(funcionarioCnpj)) {
            List<Endereco> enderecosCnpj = enderecoRepository.findByFuncionarioCnpj((Long) funcionarioClt.get().getId());
            List<Dependente> dependentesCnpj = dependenteRepositry.findByFuncinarioCnpj((Long) funcionarioClt.get().getId());
            Optional<Salario> salarioCnpj = salarioRepository.findByFuncionarioCnpj((Long) funcionarioCnpj.get().getId());
            Optional<AuxilioAlimentacao> auxilioAlimentacaoCnpj = auxilioAlimentacaoRepository.findBySalario((Long) salarioCnpj.get().getId());
            Optional<AuxilioTransporte> auxilioTransporteCnpj = auxilioTransporteRepository.findBySalario((Long) salarioCnpj.get().getId());
        }


        funcionarioCompleRetornoDto = this.mapearFuncionario(funcionario);

        if(Objects.nonNull(funcionarioClt)){
            FuncionarioCltRetornoDto funcionarioCltRetornoDto = new FuncionarioCltRetornoDto();
            funcionarioCltRetornoDto = this.mapearFuncionarioClt(funcionarioClt);
            funcionarioCompleRetornoDto.setFuncionarioClt(funcionarioCltRetornoDto);
        }

        if(Objects.nonNull(funcionarioClt)){
            FuncionarioCnpjRetornoDto funcionarioCnpjRetornoDto = new FuncionarioCnpjRetornoDto();
            funcionarioCompleRetornoDto.setFuncionarioCnpj(this.mapearFuncionarioCnpj(funcionarioCnpjRetornoDto));
            funcionarioCompleRetornoDto.setFuncionarioCnpj(funcionarioCnpjRetornoDto);
        }

        return funcionarioCompleRetornoDto;
    }

    private FuncionarioCnpjRetornoDto mapearFuncionarioCnpj(FuncionarioCnpjRetornoDto funcionarioCnpjRetornoDto) {

        FuncionarioCltRetornoDto funcionarioCltRetornoDto = new FuncionarioCltRetornoDto();

        return funcionarioCnpjRetornoDto;
    }

    private FuncionarioCltRetornoDto mapearFuncionarioClt(Optional<FuncionarioClt> funcionarioClt) {

        FuncionarioCltRetornoDto funcionarioCltRetornoDto = new FuncionarioCltRetornoDto();

        if(Objects.nonNull(funcionarioClt)){

            funcionarioCltRetornoDto.setId(funcionarioClt.get().getId());
        }

        return funcionarioCltRetornoDto;
    }

    private FuncionarioCompleRetornoDto mapearFuncionario(Optional<Funcionario> funcionario) {
        FuncionarioCompleRetornoDto funcionarioCompleRetornoDto = new FuncionarioCompleRetornoDto();
        if(Objects.nonNull(funcionario)){

            funcionarioCompleRetornoDto.setId(funcionario.get().getId());
            funcionarioCompleRetornoDto.setIdentificadorFunciona(funcionario.get().getIdentificadorFuncionario());
            funcionarioCompleRetornoDto.setMatricula(funcionario.get().getNumeroFuncionario());
        }

        return funcionarioCompleRetornoDto;
    }
}
