package br.com.funcionario.infra.exception.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class FuncionarioCltException extends RuntimeException {

    public FuncionarioCltException() {
        super();
    }

    public FuncionarioCltException(String mensagem) {
        super(mensagem);
    }

    public FuncionarioCltException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
