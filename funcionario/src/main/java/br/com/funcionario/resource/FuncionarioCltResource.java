package br.com.funcionario.resource;

import br.com.funcionario.service.FuncionarioCltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario/clt")
public class FuncionarioCltResource {

    @Autowired
    private FuncionarioCltService funcionarioCltService;

}
