package br.com.funcionario.infra.exception.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class EnderecoException extends RuntimeException {

    public EnderecoException() {
        super();
    }

    public EnderecoException(String mensagem) {
        super(mensagem);
    }

    public EnderecoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
