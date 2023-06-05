package br.com.funcionario.utils;

import org.springframework.stereotype.Component;

@Component
public class FormataRg {

    public String formataRg(String rg) {
        String formataRg = rg.replace(".", "").trim();
        formataRg = formataRg.replace(" ", "");
        formataRg = formataRg.replace("-", "");
        formataRg = formataRg.replace("/", "");
        return formataRg;
    }
}
