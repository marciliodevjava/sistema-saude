package br.com.gorvenancia.resource;

import br.com.gorvenancia.domain.Usuario;
import br.com.gorvenancia.dto.DadosAutenticacaoDto;
import br.com.gorvenancia.dto.DadosTokenJWT;
import br.com.gorvenancia.dto.UsuarioDto;
import br.com.gorvenancia.infra.security.TokenService;
import br.com.gorvenancia.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("/login")
public class UsuarioResource {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados){
        var Autenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(Autenticationtoken);

        String tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        var dataInicial = LocalDateTime.now().toInstant(ZoneOffset.of("-03:00"));
        var dataFinal = LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));

        return ResponseEntity.ok(new DadosTokenJWT(dados.login(), dataInicial, dataFinal, tokenJWT));
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
