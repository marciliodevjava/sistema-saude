package br.com.gorvenancia.resource;

import br.com.gorvenancia.dto.UsuarioDto;
import br.com.gorvenancia.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UsuarioResource {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioDto usuario) {

        UsuarioDto retorno = usuariosService.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }


    @GetMapping("/port")
    public String retornaPort(@Value("${local.server.port}") String port) {
        return String.format("Requisição respondida pela instancia na porta %s", port);
    }
}
