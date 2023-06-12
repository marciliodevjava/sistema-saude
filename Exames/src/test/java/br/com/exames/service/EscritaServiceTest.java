package br.com.exames.service;

import br.com.exames.dto.request.EnderecoRequestDto;
import br.com.exames.dto.request.FormularioRequestDto;
import br.com.exames.dto.request.MedicoRequestDto;
import br.com.exames.dto.request.PacienteRequestDto;
import br.com.exames.dto.response.FomularioResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
public class EscritaServiceTest {

    private final String DATA = "2023/06/07";
    private final String HORA = "19:06:00";
    private final String NOME_MEDICO = "heitor_duarte@id.uff.br Débora Corte Real";
    private final String NOME_PACIENTE = "Anthony Leonardo Ruan Barros";
    private final String RG_MEDICO = "27.269.522-1";
    private final String RG_PACIENTE = "40.277.732-3";
    private final String CPF_MEDICO = "749.751.505-57";
    private final String CPF_PACIENTE = "772.335.676-54";
    private final String EMAIL_MEDICO = "fernandaMedica@teste.com.br";
    private final String EMAIL_PACIENTE = "anotnyPaciente@teste.com.br";
    private final String CRN_MEDICO = "1652598";
    private final String DATA_NASCIMENTO_MEDICO = "1991/02/25";
    private final String DATA_NASCIMENTO_PACIENTE = "1994/12/25";
    private final String CEP = "72815-430";
    private final String ENDERECO = "QR 1G Lote 5 Quadra 86";
    private final String NUMERO = "25";
    private final String BAIRRO = "São Paulo";
    private final String UF = "GO";
    private final String COMPLEMENTO = "Portão Amarelo";
    private final String CIDADE = "Goiania";

    @Autowired
    private EscritaService escritaService;


    @Test
    void salvarFormularioUnico() throws ParseException {
        FormularioRequestDto formularioRequest = this.montarFormulario();

        FomularioResponseDto formulario = escritaService.salvaFormulario(formularioRequest);

        Assertions.assertEquals(HORA, formulario.getHora());
    }

    private FormularioRequestDto montarFormulario() {

        FormularioRequestDto formularioRequestDto = new FormularioRequestDto();

        formularioRequestDto.setData(DATA);
        formularioRequestDto.setHora(HORA);
        formularioRequestDto.setMedico(this.mapeiaMedico());
        formularioRequestDto.setPaciente(this.mapeiaPaciente());

        return formularioRequestDto;
    }

    private MedicoRequestDto mapeiaMedico() {

        MedicoRequestDto medicoDto = new MedicoRequestDto();

        medicoDto.setNome(NOME_MEDICO);
        medicoDto.setRg(RG_MEDICO);
        medicoDto.setCpf(CPF_MEDICO);
        medicoDto.setEmail(EMAIL_MEDICO);
        medicoDto.setCrn(CRN_MEDICO);
        medicoDto.setDataNascimento(DATA_NASCIMENTO_MEDICO);
        medicoDto.setEndereco(this.mapeiaEndereco());

        return medicoDto;
    }

    private PacienteRequestDto mapeiaPaciente(){

        PacienteRequestDto pacienteDto = new PacienteRequestDto();

        pacienteDto.setNome(NOME_PACIENTE);
        pacienteDto.setRg(RG_PACIENTE);
        pacienteDto.setCpf(CPF_PACIENTE);
        pacienteDto.setEmail(EMAIL_PACIENTE);
        pacienteDto.setDataNascimento(DATA_NASCIMENTO_PACIENTE);
        pacienteDto.setEndereco(this.mapeiaEndereco());

        return pacienteDto;
    }

    private EnderecoRequestDto mapeiaEndereco() {

        EnderecoRequestDto endereco = new EnderecoRequestDto();

        endereco.setCep(CEP);
        endereco.setEndereco(ENDERECO);
        endereco.setNumero(NUMERO);
        endereco.setBairro(BAIRRO);
        endereco.setCidade(CIDADE);
        endereco.setUf(UF);
        endereco.setComplemento(COMPLEMENTO);

        return endereco;
    }
}
