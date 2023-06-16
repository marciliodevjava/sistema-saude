package br.com.gerador.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class FormatadorData {
    private final String FORMATAR_DATA = "yyyy/mm/dd";
    public LocalDateTime converterStringParaData(Date dataNascimento) throws ParseException {
        DateFormat formato = new SimpleDateFormat(FORMATAR_DATA);
        Date data = formato.parse(String.valueOf(dataNascimento));
        return data;
    }
}
