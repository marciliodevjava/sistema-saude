package br.com.funcionario.service.v0;

import br.com.funcionario.domain.Salario;
import br.com.funcionario.dto.request.SalarioDto;
import br.com.funcionario.dto.response.SalarioRetornoDto;
import br.com.funcionario.mapper.v0.SalarioMapper;
import br.com.funcionario.repository.SalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalarioService {

    @Autowired
    private SalarioRepository salarioRepository;
    @Autowired
    private SalarioMapper salarioMapper;

    public SalarioRetornoDto savarSalario(SalarioDto salarioDto) {

        Salario salario = salarioMapper.MapearSalario(salarioDto);
        salario= salarioRepository.save(salario);

        SalarioRetornoDto retorno = salarioMapper.mapeiaRetornoSalario(salario);

        return retorno;
    }
}
