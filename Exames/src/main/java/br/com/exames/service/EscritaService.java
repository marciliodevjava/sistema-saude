package br.com.exames.service;

import br.com.exames.domain.Endereco;
import br.com.exames.domain.Formulario;
import br.com.exames.domain.Medico;
import br.com.exames.domain.Paciente;
import br.com.exames.dto.request.FormularioRequestDto;
import br.com.exames.dto.response.FomularioResponseDto;
import br.com.exames.mapper.MapperEscrita;
import br.com.exames.repository.EnderecoRepository;
import br.com.exames.repository.FormularioRepository;
import br.com.exames.repository.MedicoRepository;
import br.com.exames.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
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
    @Autowired
    private EnderecoRepository enderecoRepository;

    public FomularioResponseDto salvaFormulario(FormularioRequestDto formularioRequestDto) throws ParseException {

        Formulario formulario = mapperEscrita.mapeiaFormularioEntrada(formularioRequestDto);
        Medico medico = mapperEscrita.mapeiaMedicoEntrada(formularioRequestDto.getMedico());
        Endereco enderecoMedico = mapperEscrita.mapeiaEnderecoEntrada(formularioRequestDto.getMedico().getEndereco());
        Paciente paciente = mapperEscrita.mapeiaPacienteEntrada(formularioRequestDto.getPaciente());
        Endereco enderecoPaciente = mapperEscrita.mapeiaEnderecoEntrada(formularioRequestDto.getPaciente().getEndereco());

        if (Objects.nonNull(formulario)) {
            formulario = formularioRepository.save(formulario);
            if (Objects.nonNull(medico)) medico.setFormulario(formulario);
            if (Objects.nonNull(paciente)) paciente.setFormulario(formulario);
        }

        if (Objects.nonNull(medico)) {
            medico = medicoRepository.save(medico);
            if (Objects.nonNull(enderecoMedico)) enderecoMedico.setMedico(medico);
        }

        if (Objects.nonNull(paciente)) {
            paciente = pacienteRepository.save(paciente);
            if (Objects.nonNull(enderecoPaciente)) enderecoPaciente.setPaciente(paciente);
        }

        if (Objects.nonNull(enderecoMedico)) enderecoRepository.save(enderecoMedico);
        if (Objects.nonNull(enderecoPaciente)) enderecoRepository.save(enderecoPaciente);

        FomularioResponseDto fomularioResponseDto = this.mapperEscrita.mapeiaFormularioSaida(formulario);

        return fomularioResponseDto;
    }

    public List<FomularioResponseDto> trazerFuncionario() {

        List<Formulario> formulario = formularioRepository.findAll();

        return null;
    }
}
