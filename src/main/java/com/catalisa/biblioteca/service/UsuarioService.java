package com.catalisa.biblioteca.service;

import com.catalisa.biblioteca.dto.UsuarioDto;
import com.catalisa.biblioteca.model.UsuarioModel;
import com.catalisa.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioModel> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel criarNovoUsuario(UsuarioDto usuarioDto) {
        validarUsuario(usuarioDto.username());
        validarPassword(usuarioDto.password());

        UsuarioModel novoUsuario = new UsuarioModel();
        novoUsuario.setUsername(usuarioDto.username());
        novoUsuario.setPassword(usuarioDto.password());
        novoUsuario.setRoles(usuarioDto.roles());

        return usuarioRepository.save(novoUsuario);
    }

    public void deletarUsuario(Long userId) {
        if (!usuarioRepository.existsById(userId)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        usuarioRepository.deleteById(userId);
    }

    //usuário só com letras e sem caracteres especiais.
    private void validarUsuario(String username) {
        if (username == null || username.length() < 6 || !username.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Nome de usuário inválido.");
        }
    }

    //Senha com pelo menos 1 caracter especial, 1 letra maiuscula e pelo menos 1 número.
    private void validarPassword(String password) {
        if (password == null || password.length() < 8 || !password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).*$")) {
            throw new IllegalArgumentException("Senha inválida.");
        }
    }


}
