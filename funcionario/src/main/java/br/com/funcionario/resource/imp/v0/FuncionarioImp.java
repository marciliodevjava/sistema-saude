package br.com.funcionario.resource.imp.v0;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.response.FuncionarioRetornoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.util.List;

public interface FuncionarioImp {

    public ResponseEntity<FuncionarioRetornoDto> salvaFuncionario(FuncionarioDto funcionarioDto, UriComponentsBuilder uriBuilder) throws ParseException;
    public ResponseEntity<FuncionarioDto> atualizarFuncionario(FuncionarioDto funcionarioDto);
    public ResponseEntity<List<FuncionarioDto>> listarFuncionario();
    public ResponseEntity<FuncionarioDto> listarFuncionarioId(Long id);
    public ResponseEntity<FuncionarioDto> deletarFuncionario(Long id);
}
