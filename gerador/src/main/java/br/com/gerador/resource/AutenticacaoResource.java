package br.com.gerador.resource;

import br.com.gerador.dto.LoginDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/login")
public class AutenticacaoResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid LoginDto dto){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        Authentication authentication = authenticationManager.authenticate(token);

        LocalDateTime dataInicial = LocalDateTime.now();
        LocalDateTime dataFinal = LocalDateTime.now().plusHours(2);

        return ResponseEntity.ok(new TokenJWT(dto.login(),token, dataInicial, dataFinal));
    }
}
