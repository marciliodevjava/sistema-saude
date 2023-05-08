package br.com.gorvenancia.service;

import br.com.gorvenancia.domain.Usuario;
import br.com.gorvenancia.dto.UsuarioDto;
import br.com.gorvenancia.repository.UsuarioRepository;
import br.com.gorvenancia.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto createUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = this.montarUsuario(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        UsuarioDto retorno = this.montarUsuarioDto(usuario);
        return retorno;
    }

    private UsuarioDto montarUsuarioDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setLogin(usuarioDto.getLogin());
        return usuarioDto;
    }

    private Usuario montarUsuario(UsuarioDto usuarioDto) {
        String senha = HashUtil.getSecureHash(usuarioDto.getSenha());
        return new Usuario(null, usuarioDto.getLogin(), senha);
    }
}
