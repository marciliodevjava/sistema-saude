package br.com.exames.service;

import br.com.exames.repository.UuidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UuidService {
    @Autowired
    private UuidRepository uuidRepository;

}
