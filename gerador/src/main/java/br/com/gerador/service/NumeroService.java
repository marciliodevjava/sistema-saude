package br.com.gerador.service;

import br.com.gerador.domain.Numero;
import br.com.gerador.dto.NumeroDto;
import br.com.gerador.repository.NumeroRepository;
import br.com.gerador.utils.GeradorUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class NumeroService {

    @Autowired
    private NumeroRepository numeroRepository;
    @Autowired
    private GeradorUUID geradorUUID;

    public NumeroDto geraNumero(Long id) {
        Numero consulta = numeroRepository.findTopByOrderByIdDesc();

        Integer numero = consulta.getMatricula();
        Numero inserir = this.montarDados(numero, id);

        this.numeroRepository.save(inserir);

        return new NumeroDto(inserir.getMatricula(), inserir.getData(), inserir.getIdFuncionario());
    }

    public NumeroDto geraNumero() {
        Numero consulta = numeroRepository.findTopByOrderByIdDesc();

        Integer numero = consulta.getMatricula();
        Numero inserir = this.montarDadosSemId(numero);

        this.numeroRepository.save(inserir);

        return new NumeroDto(inserir.getMatricula(), inserir.getData(), inserir.getIdFuncionario());
    }

    public Page<NumeroDto> buscarNumeros(Pageable pageable) {
        Page<Numero> resultado = numeroRepository.findAll(pageable);
        Page<NumeroDto> retorno = resultado.map(e -> new NumeroDto(e.getMatricula(), e.getData(), e.getIdFuncionario()));
        return retorno;
    }

    private Numero montarDados(Integer numero, Long id) {
        Numero numeroInserir = new Numero();
        LocalDateTime dateTime = LocalDateTime.now();
        Integer valor = 1;
        Integer soma = numero + valor;

        numeroInserir.setIdentificadorNumero(geradorUUID.getIdentificador());
        numeroInserir.setMatricula(soma);
        numeroInserir.setData(dateTime);
        numeroInserir.setIdFuncionario(id);

        return numeroInserir;
    }

    private Numero montarDadosSemId(Integer numero) {
        Numero numeroInserir = new Numero();
        LocalDateTime dateTime = LocalDateTime.now();
        Integer valor = 1;
        Integer soma = numero + valor;

        numeroInserir.setIdentificadorNumero(geradorUUID.getIdentificador());
        numeroInserir.setMatricula(soma);
        numeroInserir.setData(dateTime);

        return numeroInserir;
    }

    public NumeroDto buscarPorId(Long id) {
        Optional<Numero> numero = numeroRepository.findById(id);

        NumeroDto numeroRetorno = this.montarDadosRetorno(numero);

        return numeroRetorno;
    }

    private NumeroDto montarDadosRetorno(Optional<Numero> numero) {
        NumeroDto numeroDto = new NumeroDto();
        numeroDto.setNumero(numero.get().getMatricula());
        numeroDto.setIdFuncionario(numeroDto.getIdFuncionario());
        numeroDto.setLocalDateTime(numero.get().getData());
        return numeroDto;
    }
}
