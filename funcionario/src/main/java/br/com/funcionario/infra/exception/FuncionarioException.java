package br.com.funcionario.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class FuncionarioException extends RuntimeException {

    public FuncionarioException() {
        super();
    }

    public FuncionarioException(String mensagem) {
        super(mensagem);
    }

    public FuncionarioException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
