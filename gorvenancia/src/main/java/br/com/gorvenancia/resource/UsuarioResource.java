package br.com.gorvenancia.resource;

import br.com.gorvenancia.dto.DadosAutenticacaoDto;
import br.com.gorvenancia.dto.UsuarioDto;
import br.com.gorvenancia.service.UsuariosService;
import br.com.gorvenancia.util.HashUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UsuarioResource {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioDto usuario) {

        UsuarioDto retorno = usuariosService.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }


    @GetMapping("/port")
    public String retornaPort(@Value("${local.server.port}") String port) {
        return String.format("Requisição respondida pela instancia na porta %s", port);
    }
}
