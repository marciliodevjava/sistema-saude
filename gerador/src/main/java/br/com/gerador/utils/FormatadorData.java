package br.com.gerador.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FormatadorData {
    private final String FORMATAR_DATA = "yyyy/mm/dd";
    public Date converterStringParaData(Date dataNascimento) throws ParseException {
        SimpleDateFormat formatoSimpleDateFormat = new SimpleDateFormat(FORMATAR_DATA);
        String dataModificada = formatoSimpleDateFormat.format(dataNascimento);
        DateFormat formato = new SimpleDateFormat(FORMATAR_DATA);
        return formato.parse(dataModificada);
    }
}
