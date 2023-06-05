package br.com.funcionario.utils;

import org.springframework.stereotype.Component;

@Component
public class FormataCpf {

    public String formataCpf(String cpf) {
        String formataCpf = cpf.replace(".", "").trim();
        formataCpf = formataCpf.replace(" ", "");
        formataCpf = formataCpf.replace("-", "");
        formataCpf = formataCpf.replace("/", "");
        return formataCpf;
    }
}
