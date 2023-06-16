package br.com.gorvenancia.service;

import br.com.gorvenancia.domain.Usuario;
import br.com.gorvenancia.dto.UsuarioDto;
import br.com.gorvenancia.repository.UsuarioRepository;
import br.com.gorvenancia.util.FormatadorData;
import br.com.gorvenancia.util.FormatadorHora;
import br.com.gorvenancia.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;

@Service
public class UsuariosService {
    private LocalTime hora;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private FormatadorData formatadorData;
    @Autowired
    private FormatadorHora formatadorHora;

    public UsuarioDto createUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = this.montarUsuario(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        UsuarioDto retorno = this.montarUsuarioDto(usuario);
        return retorno;
    }

    private UsuarioDto montarUsuarioDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setLogin(usuario.getLogin());
        return usuarioDto;
    }

    private Usuario montarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        String senha = HashUtil.getSecureHash(usuarioDto.getSenha());

        usuario.setLogin(usuario.getLogin());
        usuario.setSenha(senha);
        usuario.setData(new Date());
        usuario.setHora(hora);
        return usuario;
    }
}
