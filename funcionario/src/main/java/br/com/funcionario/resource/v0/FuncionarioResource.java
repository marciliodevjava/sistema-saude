package br.com.funcionario.resource.v0;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.response.FuncionarioRetornoDto;
import br.com.funcionario.resource.imp.v0.FuncionarioImp;
import br.com.funcionario.service.v0.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource implements FuncionarioImp {

    private URI uri;
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/salvar")
    public ResponseEntity<FuncionarioRetornoDto> salvarSomenteFuncionario(FuncionarioDto funcionarioDto, UriComponentsBuilder uriBuilder) {
        FuncionarioRetornoDto funcionario = funcionarioService.salvarSomenteFuncionario(funcionarioDto);
        this.uri = uriBuilder.path("/{id}").buildAndExpand(funcionario.getIdentificadorFuncionario()).toUri();
        return ResponseEntity.created(uri).body(funcionario);
    }

    @PostMapping
    @Override
    public ResponseEntity<FuncionarioRetornoDto> salvaFuncionario(@RequestBody FuncionarioDto funcionarioDto, UriComponentsBuilder uriBuilder) throws ParseException {
        FuncionarioRetornoDto funcionario = funcionarioService.salvarFuncionario(funcionarioDto);
        this.uri = uriBuilder.path("/{id}").buildAndExpand(funcionario.getIdentificadorFuncionario()).toUri();
        return ResponseEntity.created(uri).body(funcionario);
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
