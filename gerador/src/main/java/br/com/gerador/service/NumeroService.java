package br.com.gerador.service;

import br.com.gerador.domain.Numero;
import br.com.gerador.dto.NumeroDto;
import br.com.gerador.repository.NumeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NumeroService {

    @Autowired
    private NumeroRepository numeroRepository;

    public NumeroDto geraNumero(Long id) {
        Numero consulta = numeroRepository.findTopByOrderByIdDesc();

        Integer numero = consulta.getNumero();
        Numero inserir = this.montarDados(numero, id);

        this.numeroRepository.save(inserir);

        return new NumeroDto(inserir.getNumero(), inserir.getData(), inserir.getIdFuncionario());
    }

    public NumeroDto geraNumero() {
        Numero consulta = numeroRepository.findTopByOrderByIdDesc();

        Integer numero = consulta.getNumero();
        Numero inserir = this.montarDadosSemId(numero);

        this.numeroRepository.save(inserir);

        return new NumeroDto(inserir.getNumero(), inserir.getData(), inserir.getIdFuncionario());
    }

    public List<NumeroDto> buscarNumeros() {
        List<Numero> resultado = numeroRepository.findAll();
        List<NumeroDto> retorno = resultado.stream()
                .map(e -> new NumeroDto(e.getNumero(), e.getData(), e.getIdFuncionario()))
                .collect(Collectors.toList());
        return retorno;
    }

    private Numero montarDados(Integer numero, Long id) {
        Numero numeroInserir = new Numero();
        LocalDateTime dateTime = LocalDateTime.now();
        Integer valor = 1;
        Integer soma = numero + valor;

        numeroInserir.setNumero(soma);
        numeroInserir.setData(dateTime);
        numeroInserir.setIdFuncionario(id);

        return numeroInserir;
    }

    private Numero montarDadosSemId(Integer numero) {
        Numero numeroInserir = new Numero();
        LocalDateTime dateTime = LocalDateTime.now();
        Integer valor = 1;
        Integer soma = numero + valor;

        numeroInserir.setNumero(soma);
        numeroInserir.setData(dateTime);

        return numeroInserir;
    }

    public NumeroDto buscarPorId(Long id) {
        Optional<Numero> numero = numeroRepository.findById(id);
        if (numero.isEmpty() || numero == null) return null;
        NumeroDto numeroRetorno = this.montarDadosRetorno(numero);

        return numeroRetorno;
    }

    private NumeroDto montarDadosRetorno(Optional<Numero> numero) {
        NumeroDto numeroDto = new NumeroDto();
        numeroDto.setNumero(numero.get().getNumero());
        numeroDto.setIdFuncionario(numeroDto.getIdFuncionario());
        numeroDto.setLocalDateTime(numero.get().getData());
        return numeroDto;
    }
}
