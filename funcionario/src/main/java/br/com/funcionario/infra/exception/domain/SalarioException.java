package br.com.funcionario.infra.exception.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class SalarioException extends RuntimeException {

    public SalarioException() {
        super();
    }

    public SalarioException(String mensagem) {
        super(mensagem);
    }

    public SalarioException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
