package br.com.funcionario.resource.v0;

import br.com.funcionario.service.v0.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario/salario")
public class SalarioResource {

    @Autowired
    private SalarioService salarioService;

}
