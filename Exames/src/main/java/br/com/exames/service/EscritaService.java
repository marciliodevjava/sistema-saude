package br.com.exames.service;

import br.com.exames.domain.Formulario;
import br.com.exames.domain.Medico;
import br.com.exames.domain.Paciente;
import br.com.exames.dto.request.FormularioRequestDto;
import br.com.exames.dto.response.FomularioResponseDto;
import br.com.exames.mapper.MapperEscrita;
import br.com.exames.repository.FormularioRepository;
import br.com.exames.repository.MedicoRepository;
import br.com.exames.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Objects;

@Service
public class EscritaService {
    @Autowired
    private MapperEscrita mapperEscrita;
    @Autowired
    private FormularioRepository formularioRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public FomularioResponseDto salvaFormulario(FormularioRequestDto formularioRequestDto) throws ParseException {

        Formulario formulario = mapperEscrita.mapeiaFormularioEntrada(formularioRequestDto);
        Medico medico = mapperEscrita.mapeiaMedicoEntrada(formularioRequestDto.getMedico());
        Paciente paciente = mapperEscrita.mapeiaPacienteEntrada(formularioRequestDto.getPaciente());

        if(Objects.nonNull(formulario)){
            formulario = formularioRepository.save(formulario);
            if(Objects.nonNull(medico)) medico.setFormulario(formulario);
            if(Objects.nonNull(paciente)) paciente.setFormulario(formulario);
        }

        if(Objects.nonNull(medico)) medico = medicoRepository.save(medico);
        if(Objects.nonNull(paciente)) paciente = pacienteRepository.save(paciente);


        FomularioResponseDto fomularioResponseDto = this.mapperEscrita.mapeiaFormularioSaida(formulario);

        return fomularioResponseDto;
    }
}
