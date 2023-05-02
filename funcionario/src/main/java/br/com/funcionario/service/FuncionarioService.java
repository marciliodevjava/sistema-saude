package br.com.funcionario.service;

import br.com.funcionario.domain.Funcionario;
import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioDto cadastrarFuncionario(FuncionarioDto funcionarioDto){
        Funcionario mapeamento = this.mapearDto(funcionarioDto);
        Funcionario retorno = funcionarioRepository.save(mapeamento);
        
        return funcionarioDto;
    }

    private Funcionario mapearDto(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = new Funcionario();
        
        funcionario.setEstadoFuncionarioEnum(funcionarioDto.getEstadoFuncionarioEnum());
        funcionario.setNumeroFuncionario(this.geraNumero());
        funcionario.setFuncionarioClt(funcionarioDto.getFuncionarioClt());
        funcionario.setFuncionarioCnpj(funcionarioDto.getFuncionarioCnpj());
        
        return funcionario;
    }

    private Integer geraNumero() {
        return 0;
    }

}
