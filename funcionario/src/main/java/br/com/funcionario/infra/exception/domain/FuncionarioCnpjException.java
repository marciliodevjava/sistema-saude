package br.com.funcionario.infra.exception.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class FuncionarioCnpjException extends RuntimeException {

    public FuncionarioCnpjException() {
        super();
    }

    public FuncionarioCnpjException(String mensagem) {
        super(mensagem);
    }

    public FuncionarioCnpjException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
