package br.com.funcionario.resource;

import br.com.funcionario.repository.DependenteRepositry;
import br.com.funcionario.service.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario/dependente")
public class DependenteResource {

    @Autowired
    private DependenteService dependenteService;
}
