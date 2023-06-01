package br.com.funcionario.service;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.request.FuncionarioCompleDto;
import br.com.funcionario.dto.response.FuncionarioCompleRetornoDto;
import br.com.funcionario.service.imp.EscritaServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscritaService implements EscritaServiceImp {


    @Override
    public FuncionarioCompleRetornoDto salvaFuncionario(FuncionarioCompleDto funcionarioCompletoDto) {
        return null;
    }

    @Override
    public ResponseEntity<FuncionarioDto> atualizarFuncionario(FuncionarioDto funcionarioDto) {
        return null;
    }

    @Override
    public ResponseEntity<List<FuncionarioDto>> listarFuncionario() {
        return null;
    }

    @Override
    public ResponseEntity<FuncionarioDto> listarFuncionarioId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<FuncionarioDto> deletarFuncionario(Long id) {
        return null;
    }
}
