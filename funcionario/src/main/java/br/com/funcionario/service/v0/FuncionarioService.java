package br.com.funcionario.service.v0;

import br.com.funcionario.domain.*;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.response.*;
import br.com.funcionario.mapper.v0.EscritaMapper;
import br.com.funcionario.repository.*;
import br.com.funcionario.service.imp.FuncionarioServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Transient;
import java.text.ParseException;
import java.util.Objects;

@Service
public class FuncionarioService implements FuncionarioServiceImp {
    @Autowired
    private EscritaMapper escritaMapper;

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

        if (Objects.nonNull(mapeamento)) funcionarioRepository.save(mapeamento);
        if (Objects.nonNull(mapeamento.getFuncionarioClt()))
            funcionarioCltRepository.save(mapeamento.getFuncionarioClt());
        if (Objects.nonNull(mapeamento.getFuncionarioClt().getSalario()))
            salarioRepository.save(mapeamento.getFuncionarioClt().getSalario());
        if (Objects.nonNull(mapeamento.getFuncionarioClt().getSalario().getAuxilioAlimentacao()))
            auxilioAlimentacaoRepository.save(mapeamento.getFuncionarioClt().getSalario().getAuxilioAlimentacao());
        if (Objects.nonNull(mapeamento.getFuncionarioClt().getSalario().getAuxilioAlimentacao()))
            auxilioTransporteRepository.save(mapeamento.getFuncionarioClt().getSalario().getAuxilioTransporte());
        if (Objects.nonNull(mapeamento.getFuncionarioClt().getDependentesList()))
            dependenteRepositry.saveAll(mapeamento.getFuncionarioClt().getDependentesList());
        if (Objects.nonNull(mapeamento.getFuncionarioClt().getEndereco()))
            enderecoRepository.saveAll(mapeamento.getFuncionarioClt().getEndereco());
        if (Objects.nonNull(mapeamento.getFuncionarioCnpj()))
            funcionarioCnpjRepository.save(mapeamento.getFuncionarioCnpj());
        if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getSalario()))
            salarioRepository.save(mapeamento.getFuncionarioCnpj().getSalario());
        if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getSalario().getAuxilioAlimentacao()))
            auxilioAlimentacaoRepository.save(mapeamento.getFuncionarioCnpj().getSalario().getAuxilioAlimentacao());
        if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getSalario().getAuxilioAlimentacao()))
            auxilioTransporteRepository.save(mapeamento.getFuncionarioCnpj().getSalario().getAuxilioTransporte());
        if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getDependentesList()))
            dependenteRepositry.saveAll(mapeamento.getFuncionarioCnpj().getDependentesList());
        if (Objects.nonNull(mapeamento.getFuncionarioCnpj().getEndereco()))
            enderecoRepository.saveAll(mapeamento.getFuncionarioCnpj().getEndereco());


        return escritaMapper.mapearFuncionarioDto(mapeamento);
    }
}
