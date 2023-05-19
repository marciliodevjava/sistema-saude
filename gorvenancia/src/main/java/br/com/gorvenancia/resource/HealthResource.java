package br.com.gorvenancia.resource;

import br.com.gorvenancia.dto.Health;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Transient;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/health")
public class HealthResource {

    @GetMapping
    public ResponseEntity<Health> health(){
        Health dados = this.gerarHealt();
        return ResponseEntity.ok(dados);
    }

    @Transient
    private Health gerarHealt() {
        return new Health("API_FUNCIONARIO", LocalDateTime.now(), HttpStatus.SC_OK);
    }
}
