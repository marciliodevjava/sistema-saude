package br.com.funcionario.resource;

import br.com.funcionario.dto.response.FuncionarioCompleRetornoDto;
import br.com.funcionario.dto.response.FuncionarioRetornoDto;
import br.com.funcionario.service.LeituraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/funcionario")
public class LeituraResource {

    @Autowired
    private LeituraService leituraService;

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioCompleRetornoDto> funcionarioLeitura(@PathVariable Long id){

        FuncionarioCompleRetornoDto funcionario = leituraService.funcionarioCompleto(id);

        return ResponseEntity.ok(funcionario);
    }
}
