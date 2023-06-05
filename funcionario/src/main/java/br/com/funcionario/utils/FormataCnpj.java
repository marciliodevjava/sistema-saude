package br.com.funcionario.utils;

import org.springframework.stereotype.Component;

@Component
public class FormataCnpj {

    public String formataCnpj(String cnpj) {
        String formataCnpj = cnpj.replace(".", "").trim();
        formataCnpj = formataCnpj.replace(" ", "");
        formataCnpj = formataCnpj.replace("-", "");
        formataCnpj = formataCnpj.replace("/", "");
        return formataCnpj;
    }
}
