package br.com.funcionario.utils;

import org.springframework.stereotype.Component;

@Component
public class FormataTelefone {

    public String formataTelefone(String rg) {
        String formataTelefone = rg.replace("-", "").trim();
        formataTelefone = formataTelefone.replace("(", "");
        formataTelefone = formataTelefone.replace(")", "");
        formataTelefone = formataTelefone.replace(" ", "");
        return formataTelefone;
    }
}
