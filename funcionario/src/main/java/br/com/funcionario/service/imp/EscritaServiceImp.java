package br.com.funcionario.service.imp;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.request.FuncionarioCompleDto;
import br.com.funcionario.dto.response.FuncionarioCompleRetornoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EscritaServiceImp {
    public FuncionarioCompleRetornoDto salvaFuncionario(FuncionarioCompleDto funcionarioCompletoDto);
    public ResponseEntity<FuncionarioDto> atualizarFuncionario(FuncionarioDto funcionarioDto);
    public ResponseEntity<List<FuncionarioDto>> listarFuncionario();
    public ResponseEntity<FuncionarioDto> listarFuncionarioId(Long id);
    public ResponseEntity<FuncionarioDto> deletarFuncionario(Long id);
}
