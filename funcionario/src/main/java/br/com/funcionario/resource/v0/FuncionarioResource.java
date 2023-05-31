package br.com.funcionario.resource.v0;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.resource.imp.FuncionarioImp;
import br.com.funcionario.service.FuncionarioService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource implements FuncionarioImp {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    @Override
    public ResponseEntity<FuncionarioDto> salvaFuncionario(FuncionarioDto funcionarioDto) {
        return null;
    }

    @PutMapping
    @Override
    public ResponseEntity<FuncionarioDto> atualizarFuncionario(FuncionarioDto funcionarioDto) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<FuncionarioDto>> listarFuncionario() {
        return null;
    }

    @GetMapping("/listar/{id}")
    @Override
    public ResponseEntity<FuncionarioDto> listarFuncionarioId(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/deletar/{id}")
    @Override
    public ResponseEntity<FuncionarioDto> deletarFuncionario(@PathVariable Long id) {
        return null;
    }
}
