package com.catalisa.biblioteca.controller;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.service.LivrosService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class LivrosController {

@Autowired
LivrosService livrosService;


    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping(path = "/registro")
    @Operation(summary = " : Lista todos os Livros", method = "GET")
    public List<LivrosModel> buscaTodosContatos(){
        return livrosService.buscarTodos();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping(path = "/registro/{id}")
    @Operation(summary = " : Lista um livro pelo ID", method = "GET")
    public Optional<LivrosModel> buscarContatoPorId(@PathVariable Long id){
        return livrosService.buscarPorId(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/registro")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = " : Cadastra um novo livro", method = "GET")
    public LivrosModel cadastrarNovoContato(@RequestBody LivrosModel livrosModel){
        return livrosService.cadastrar(livrosModel);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/registro/{id}")
    @Operation(summary = " : Edita um livro pelo ID", method = "GET")
    public LivrosModel alteraContato(@PathVariable Long id, @RequestBody LivrosModel livrosModel){
        return livrosService.alterar(id, livrosModel);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/registro/{id}")
    @Operation(summary = " : Deleta um livro pelo ID", method = "GET")
    public void deletaContato(@PathVariable Long id){
        livrosService.deletar(id);
    }
    }


