package br.com.exames.service;

import br.com.exames.domain.Endereco;
import br.com.exames.domain.Formulario;
import br.com.exames.domain.Medico;
import br.com.exames.domain.Paciente;
import br.com.exames.dto.request.EnderecoRequestDto;
import br.com.exames.dto.request.FormularioRequestDto;
import br.com.exames.dto.request.MedicoRequestDto;
import br.com.exames.dto.request.PacienteRequestDto;
import br.com.exames.dto.response.FomularioResponseDto;
import br.com.exames.mapper.MapperEscrita;
import br.com.exames.repository.EnderecoRepository;
import br.com.exames.repository.FormularioRepository;
import br.com.exames.repository.MedicoRepository;
import br.com.exames.repository.PacienteRepository;
import br.com.exames.utils.FormatadorDate;
import br.com.exames.utils.FormatadorHora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    @Autowired
    private FormatadorDate formatadorDate;
    @Autowired
    private FormatadorHora formatadorHora;

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

    public FomularioResponseDto trazerFuncionario(Long id) {

        Optional<Formulario> formulario = formularioRepository.findById(id);

        if (Objects.nonNull(formulario)) {
            Medico medico = medicoRepository.findByFormulario(formulario.get().getId());
            Endereco enderecoMedico = enderecoRepository.findByMedico(medico.getId());
            medico.setEndereco(enderecoMedico);
            Paciente paciente = pacienteRepository.findByFormulario(formulario.get().getId());
            Endereco enderecoPaciente = enderecoRepository.findByPaciente(paciente.getId());
            paciente.setEndereco(enderecoPaciente);

            formulario.get().setMedico(medico);
            formulario.get().setPaciente(paciente);
        }

        FomularioResponseDto formularioResponseDto = this.mapeiaFormularioRetorno(formulario);

        return formularioResponseDto;
    }

    private FomularioResponseDto mapeiaFormularioRetorno(Optional<Formulario> formularioRetorno) {

        FomularioResponseDto formularioRequestDto = new FomularioResponseDto();
        if (Objects.nonNull(formularioRetorno)) {

            Formulario formulario = formularioRetorno.get();

            formularioRequestDto.setId(formulario.getId());
            formularioRequestDto.setIdentificador(formulario.getIdFormulario());
            formularioRequestDto.setData(formatadorDate.converterDateParaString(formulario.getData()));
            formularioRequestDto.setHora(formatadorHora.converterTimeParaString(formulario.getHora()));
            formularioRequestDto.setMedico(this.mapeiaMedicoRetornoDto(formulario.getMedico()));
            formularioRequestDto.setPaciente(this.mapeiaPacienteRetornoDto(formulario.getPaciente()));

            return formularioRequestDto;
        }
        return null;
    }

    private PacienteRequestDto mapeiaPacienteRetornoDto(Paciente paciente) {

        PacienteRequestDto pacienteRequestDto = new PacienteRequestDto();

        if (Objects.nonNull(paciente)) {

            pacienteRequestDto.setId(paciente.getId());
            pacienteRequestDto.setNome(paciente.getNome());
            pacienteRequestDto.setRg(paciente.getRg());
            pacienteRequestDto.setCpf(paciente.getCpf());
            pacienteRequestDto.setEmail(paciente.getEmail());
            pacienteRequestDto.setDataNascimento(formatadorDate.converterDateParaString(paciente.getDataNascimento()));
            pacienteRequestDto.setAtivo(paciente.getAtivo());
            pacienteRequestDto.setEndereco(this.mapeiaEnderecoRetornoDto(paciente.getEndereco()));

            return pacienteRequestDto;
        }

        return null;
    }

    private MedicoRequestDto mapeiaMedicoRetornoDto(Medico medico) {

        MedicoRequestDto medicoRequestDto = new MedicoRequestDto();

        if (Objects.nonNull(medico)) {

            medicoRequestDto.setId(medico.getId());
            medicoRequestDto.setNome(medico.getNome());
            medicoRequestDto.setRg(medico.getRg());
            medicoRequestDto.setCpf(medico.getCpf());
            medicoRequestDto.setEmail(medico.getEmail());
            medicoRequestDto.setCrn(medico.getCrn());
            medicoRequestDto.setDataNascimento(formatadorDate.converterDateParaString(medico.getDataNascimento()));
            medicoRequestDto.setAtivo(medico.getAtivo());
            medicoRequestDto.setEndereco(this.mapeiaEnderecoRetornoDto(medico.getEndereco()));

            return medicoRequestDto;
        }

        return null;
    }


    private EnderecoRequestDto mapeiaEnderecoRetornoDto(Endereco endereco) {

        EnderecoRequestDto enderecoRequestDto = new EnderecoRequestDto();

        if (Objects.nonNull(endereco)) {

            enderecoRequestDto.setId(endereco.getId());
            enderecoRequestDto.setCep(endereco.getCep());
            enderecoRequestDto.setEndereco(endereco.getEndereco());
            enderecoRequestDto.setNumero(endereco.getNumero());
            enderecoRequestDto.setBairro(endereco.getBairro());
            enderecoRequestDto.setCidade(endereco.getCidade());
            enderecoRequestDto.setUf(endereco.getUf());
            enderecoRequestDto.setComplemento(endereco.getComplemento());
            enderecoRequestDto.setAtivo(endereco.getAtivo());

            return enderecoRequestDto;
        }

        return null;
    }
}
