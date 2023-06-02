package br.com.funcionario.service.imp;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.response.FuncionarioRetornoDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;

public interface FuncionarioServiceImp {
    public FuncionarioRetornoDto salvarFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) throws ParseException;
}
