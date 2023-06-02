package br.com.funcionario.resource;

import br.com.funcionario.dto.FuncionarioDto;
import br.com.funcionario.dto.request.FuncionarioCompleDto;
import br.com.funcionario.dto.response.FuncionarioCompleRetornoDto;
import br.com.funcionario.resource.imp.EscritaImp;
import br.com.funcionario.service.EscritaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class EscritaResource implements EscritaImp {

    @Autowired
    private EscritaService escritaService;


    @PostMapping("/salvar")
    @Override
    public ResponseEntity<FuncionarioCompleDto> salvaFuncionarioCompleto(@RequestBody @Valid FuncionarioCompleDto funcionarioCompletoDto) {
        FuncionarioCompleRetornoDto funcionario = escritaService.salvaFuncionario(funcionarioCompletoDto);
        return null;
    }

    @PutMapping("/atualizar")
    @Override
    public ResponseEntity<FuncionarioCompleDto> atualizarFuncionarioCompleto(FuncionarioDto funcionarioDto) {
        return null;
    }

    @GetMapping("/listar-todos")
    @Override
    public ResponseEntity<List<FuncionarioCompleDto>> listarFuncionarioCompleto() {
        return null;
    }

    @GetMapping("/listar/{id}")
    @Override
    public ResponseEntity<FuncionarioCompleDto> listarFuncionarioIdCompleto(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/excluir")
    @Override
    public ResponseEntity<FuncionarioCompleDto> deletarFuncionarioCompleto(Long id) {
        return null;
    }
}
