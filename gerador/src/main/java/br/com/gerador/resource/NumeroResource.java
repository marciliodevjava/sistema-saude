package br.com.gerador.resource;

import br.com.gerador.dto.NumeroDto;
import br.com.gerador.service.NumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerador-numero")
public class NumeroResource {

    @Autowired
    private NumeroService numeroService;

    @GetMapping()
    public ResponseEntity<NumeroDto> gerarNumero(@PathVariable Long id){
        NumeroDto numeroRetorno = numeroService.geraNumero(id);

        return ResponseEntity.ok(numeroRetorno);
    }

    @GetMapping("/port")
    public String retornaPort(@Value("${local.server.port}") String port) {
        return String.format("Requisição respondida pela instancia na porta %s", port);
    }
}
