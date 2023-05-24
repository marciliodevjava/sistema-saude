package br.com.funcionario.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class DependenteException extends RuntimeException {

    public DependenteException() {
        super();
    }

    public DependenteException(String mensagem) {
        super(mensagem);
    }

    public DependenteException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
