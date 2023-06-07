package br.com.funcionario.resource.v0;

import br.com.funcionario.dto.request.SalarioDto;
import br.com.funcionario.dto.response.SalarioRetornoDto;
import br.com.funcionario.service.v0.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario/salario")
public class SalarioResource {

    @Autowired
    private SalarioService salarioService;

    @PostMapping("/gravar")
    public ResponseEntity<SalarioRetornoDto> salvarSalario(@RequestBody SalarioDto salarioDto){

        SalarioRetornoDto salarioRetornoDto = salarioService.savarSalario(salarioDto);

        return ResponseEntity.ok(salarioRetornoDto);
    }

}
