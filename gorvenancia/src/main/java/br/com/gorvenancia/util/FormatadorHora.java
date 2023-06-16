package br.com.gorvenancia.util;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class FormatadorHora {
    private final String FORMATAR_HORA = "HH:mm:ss";

    public LocalTime converterStringParaHora(String horario) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(FORMATAR_HORA);
        return LocalTime.parse(horario, formato);
    }
}
