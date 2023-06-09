package br.com.exames.mapper;

import br.com.exames.domain.Endereco;
import br.com.exames.domain.Formulario;
import br.com.exames.domain.Medico;
import br.com.exames.domain.Paciente;
import br.com.exames.dto.request.EnderecoRequestDto;
import br.com.exames.dto.request.FormularioRequestDto;
import br.com.exames.dto.request.MedicoRequestDto;
import br.com.exames.dto.request.PacienteRequestDto;
import br.com.exames.dto.response.FomularioResponseDto;
import br.com.exames.utils.FormatadorDate;
import br.com.exames.utils.FormatadorHora;
import br.com.exames.utils.FormatarPessoa;
import br.com.exames.utils.GeradorUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Objects;

@Component
public class MapperEscrita {

    @Autowired
    private GeradorUuid geradorUuid;
    @Autowired
    private FormatadorDate formatadorDate;
    @Autowired
    private FormatadorHora formatadorHora;
    @Autowired
    private FormatarPessoa form;
    public Formulario mapeiaFormularioEntrada(FormularioRequestDto formularioRequestDto) throws ParseException {

        Formulario formulario = new Formulario();

        if(Objects.nonNull(formularioRequestDto)){

            formulario.setIdFormulario(geradorUuid.getIdentificador());
            formulario.setData(this.formatadorDate.converterStringParaData(formularioRequestDto.getData()));
            formulario.setHora(this.formatadorHora.converterStringParaHora(formularioRequestDto.getHora()));

            return formulario;
        }

        return null;
    }

    public FomularioResponseDto mapeiaFormularioSaida(Formulario formulario) {

        FomularioResponseDto response = new FomularioResponseDto();

        if(Objects.nonNull(formulario)){

            response.setId(formulario.getId());
            response.setIdentificador(formulario.getIdFormulario());
            response.setHora(this.formatadorHora.converterTimeParaString(formulario.getHora()));
            response.setData(this.formatadorDate.converterDateParaString(formulario.getData()));

            return response;
        }

        return null;
    }

    public Medico mapeiaMedicoEntrada(MedicoRequestDto medicoDto) throws ParseException {

        if(Objects.nonNull(medicoDto)) {

            Medico medico = new Medico();

            medico.setIdMedico(geradorUuid.getIdentificador());
            medico.setNome(medicoDto.getNome());
            medico.setRg(medicoDto.getRg());
            medico.setCpf(medicoDto.getCpf());
            medico.setEmail(medicoDto.getEmail());
            medico.setCrn(medicoDto.getCrn());
            medico.setDataNascimento(this.formatadorDate.converterStringParaData(medicoDto.getDataNascimento()));
            medico.setAtivo((byte) 1);

            return medico;
        }

        return null;
    }

    public Paciente mapeiaPacienteEntrada(PacienteRequestDto pacienteDto) throws ParseException {

        if(Objects.nonNull(pacienteDto)) {

            Paciente paciente = new Paciente();

            paciente.setIdPaciente(geradorUuid.getIdentificador());
            paciente.setNome(pacienteDto.getNome());
            paciente.setRg(pacienteDto.getRg());
            paciente.setCpf(pacienteDto.getCpf());
            paciente.setEmail(pacienteDto.getEmail());
            paciente.setDataNascimento(this.formatadorDate.converterStringParaData(pacienteDto.getDataNascimento()));
            paciente.setAtivo((byte) 1);

            return paciente;
        }

        return null;
    }

    public Endereco mapeiaEnderecoEntrada(EnderecoRequestDto enderecoDto) {

        if(Objects.nonNull(enderecoDto)){

            Endereco endereco = new Endereco();

            endereco.setIdEndereco(geradorUuid.getIdentificador());
            endereco.setCep(endereco.getCep());
            endereco.setEndereco(enderecoDto.getEndereco());
            endereco.setNumero(enderecoDto.getNumero());
            endereco.setBairro(enderecoDto.getBairro());
            endereco.setCidade(endereco.getCidade());
            endereco.setUf(endereco.getUf());
            endereco.setComplemento(enderecoDto.getComplemento());
            endereco.setAtivo((byte) 1);

            return endereco;
        }

        return null;
    }
}
