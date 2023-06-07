package br.com.exames.utils;

import org.springframework.stereotype.Component;

@Component
public class FormatarPessoa {

    public String formataCpf(String cpf) {
        String formataCpf = cpf.replace(".", "").trim();
        formataCpf = formataCpf.replace(" ", "");
        formataCpf = formataCpf.replace("-", "");
        formataCpf = formataCpf.replace("/", "");
        return formataCpf;
    }

    public String formataRg(String rg) {
        String formataRg = rg.replace(".", "").trim();
        formataRg = formataRg.replace(" ", "");
        formataRg = formataRg.replace("-", "");
        formataRg = formataRg.replace("/", "");
        return formataRg;
    }

    public String formataTelefone(String rg) {
        String formataTelefone = rg.replace("-", "").trim();
        formataTelefone = formataTelefone.replace("(", "");
        formataTelefone = formataTelefone.replace(")", "");
        formataTelefone = formataTelefone.replace(" ", "");
        return formataTelefone;
    }
}
