package br.com.funcionario.resource.v0;

import br.com.funcionario.service.v0.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario/dependente")
public class DependenteResource {

    @Autowired
    private DependenteService dependenteService;
}
