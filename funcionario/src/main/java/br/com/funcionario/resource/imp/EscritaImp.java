package br.com.funcionario.resource.imp;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.request.FuncionarioCompleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EscritaImp {

    public ResponseEntity<FuncionarioCompleDto> salvaFuncionarioCompleto(FuncionarioCompleDto funcionarioCompletoDto);
    public ResponseEntity<FuncionarioCompleDto> atualizarFuncionarioCompleto(FuncionarioDto funcionarioDto);
    public ResponseEntity<List<FuncionarioCompleDto>> listarFuncionarioCompleto();
    public ResponseEntity<FuncionarioCompleDto> listarFuncionarioIdCompleto(Long id);
    public ResponseEntity<FuncionarioCompleDto> deletarFuncionarioCompleto(Long id);
}
