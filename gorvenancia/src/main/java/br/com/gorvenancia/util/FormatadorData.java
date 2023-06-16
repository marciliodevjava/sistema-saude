package br.com.gorvenancia.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FormatadorData {
    private final String FORMATAR_DATA = "yyyy/mm/dd";


    public String converterDateParaString(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat(FORMATAR_DATA);
        return formato.format(data);
    }
}
