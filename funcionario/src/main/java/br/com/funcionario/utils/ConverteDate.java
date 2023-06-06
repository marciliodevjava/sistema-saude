package br.com.funcionario.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConverteDate {

    private final String FORMATAR_DATA = "yyyy/mm/dd";


    public String converterDateParaString(Date dataNascimento) {
        SimpleDateFormat formato = new SimpleDateFormat(FORMATAR_DATA);
        return formato.format(dataNascimento);
    }

    public Date converterStringParaData(String dataNascimento) throws ParseException {
        DateFormat formato = new SimpleDateFormat(FORMATAR_DATA);
        Date data = formato.parse(dataNascimento);
        return data;
    }

}
