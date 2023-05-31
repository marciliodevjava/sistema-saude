package br.com.funcionario.resource.imp;

import br.com.funcionario.dto.FuncionarioDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FuncionarioImp {

    public ResponseEntity<FuncionarioDto> salvaFuncionario(FuncionarioDto funcionarioDto);
    public ResponseEntity<FuncionarioDto> atualizarFuncionario(FuncionarioDto funcionarioDto);
    public ResponseEntity<List<FuncionarioDto>> listarFuncionario();
    public ResponseEntity<FuncionarioDto> listarFuncionarioId(Long id);
    public ResponseEntity<FuncionarioDto> deletarFuncionario(Long id);
}
