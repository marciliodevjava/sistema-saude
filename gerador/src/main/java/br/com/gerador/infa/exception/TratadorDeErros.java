package br.com.gerador.infa.exception;

import br.com.gerador.infa.exception.enuns.MessagemEnum;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.http.auth.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class TratadorDeErros {

    private final String projetoNome = "Api Gerador";
    @Value("${spring.application.name}")
    private String projeto;
    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroResponse> tratarErro404(EntityNotFoundException ex) {

        ErroResponse errorResponse = new ErroResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMensagem(Collections.singletonList(MessagemEnum.ERROR_ENTITY_NOT_FOUND.getMensagem()));
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        errorResponse.setEndpoint(request.getRequestURI());
        errorResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErroResponse> tratarErro404(NoSuchElementException ex) {

        ErroResponse errorResponse = new ErroResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMensagem(Collections.singletonList(MessagemEnum.ERRO_NO_SUCH_ELEMENT.getMensagem()));
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        errorResponse.setEndpoint(request.getRequestURI());
        errorResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> tratarErro400(MethodArgumentNotValidException ex) {

        ErroResponse errorResponse = new ErroResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMensagem(Collections.singletonList("Erro: " + ex.getFieldErrors() + MessagemEnum.ERRO_METHOD_ARGUMENT_NOT_VALID.getMensagem()));
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        errorResponse.setEndpoint(request.getRequestURI());
        errorResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponse> tratarErro400(HttpMessageNotReadableException ex) {

        ErroResponse errorResponse = new ErroResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMensagem(Collections.singletonList(MessagemEnum.ERRO_HTTP_MESSAGE_NOT_REABLE.getMensagem()));
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        errorResponse.setEndpoint(request.getRequestURI());
        errorResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErroResponse> tratarErroBadCredentials() {
        ErroResponse errorResponse = new ErroResponse();

        errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setMensagem(Collections.singletonList(MessagemEnum.ERRO_BAD_CREDENTIALS.getMensagem()));
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        errorResponse.setEndpoint(request.getRequestURI());
        errorResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErroResponse> tratarErroAuthentication() {
        ErroResponse errorResponse = new ErroResponse();

        errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setMensagem(Collections.singletonList(MessagemEnum.ERRO_AUTHENTICATION.getMensagem()));
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        errorResponse.setEndpoint(request.getRequestURI());
        errorResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErroResponse> tratarErroAcessoNegado() {
        ErroResponse errorResponse = new ErroResponse();

        errorResponse.setStatus(HttpStatus.FORBIDDEN.value());
        errorResponse.setMensagem(Collections.singletonList(MessagemEnum.ERRO_AUTHENTICATION.getMensagem()));
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        errorResponse.setEndpoint(request.getRequestURI());
        errorResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> tratarErro500(Exception ex) {
        ErroResponse errorResponse = new ErroResponse();

        errorResponse.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        errorResponse.setMensagem(Collections.singletonList("Erro: " + ex.getLocalizedMessage()));
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        errorResponse.setEndpoint(request.getRequestURI());
        errorResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroResponse> tratarErroRuntime(RuntimeException ex) {
        ErroResponse errorResponse = new ErroResponse();

        errorResponse.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        errorResponse.setMensagem(Collections.singletonList("Erro: " + ex.getLocalizedMessage()));
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        errorResponse.setEndpoint(request.getRequestURI());
        errorResponse.setProjeto(projetoNome);

        return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }
}