package br.com.funcionario.resource.v0;

import br.com.funcionario.service.v0.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

}
