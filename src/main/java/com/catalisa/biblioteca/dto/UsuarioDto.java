package com.catalisa.biblioteca.dto;

import com.catalisa.biblioteca.model.RoleModel;
import java.util.List;

public record UsuarioDto(String username, String password, List<RoleModel> roles) {
}
