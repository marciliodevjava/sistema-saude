package br.com.funcionario.resource;

import br.com.funcionario.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

}
