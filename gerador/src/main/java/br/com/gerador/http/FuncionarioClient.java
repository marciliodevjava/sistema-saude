package br.com.gerador.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("funcionario-ms")
public interface FuncionarioClient {

    @RequestMapping(method = RequestMethod.POST, value = "/gerador")
    void geraNumero(@PathVariable Long id);
}
