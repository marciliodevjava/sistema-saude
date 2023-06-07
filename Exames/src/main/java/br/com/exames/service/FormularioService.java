package br.com.exames.service;

import br.com.exames.repository.FormularioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormularioService {

    @Autowired
    private FormularioRepository formularioRepository;

}
