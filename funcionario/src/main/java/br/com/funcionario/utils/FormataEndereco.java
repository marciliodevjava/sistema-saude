package br.com.funcionario.utils;

import org.springframework.stereotype.Component;

@Component
public class FormataEndereco {

    public String formataCep(String cep) {
        return cep.replace("-", "").trim();
    }

    public String formataUf(String uf) {
        return uf.toUpperCase().trim();
    }

    public String formataLogradouro(String logradouro) {
        return logradouro.toUpperCase().trim();
    }

    public String formataNumero(String numero) {
        return numero.toUpperCase().trim();
    }

    public String formataBairro(String bairro) {
        return bairro.toUpperCase().trim();
    }

    public String formataCidade(String cidade) {
        return cidade.toUpperCase().trim();
    }
}
