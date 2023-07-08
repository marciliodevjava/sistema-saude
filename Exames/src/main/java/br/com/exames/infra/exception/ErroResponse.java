package br.com.exames.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErroResponse {

    private int staus;
    private List<String> mensagem;
    private String timeStamp;
    private String endpoint;
    private String projeto;
}
