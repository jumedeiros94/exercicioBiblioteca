package com.catalisa.biblioteca.controller;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.service.LivrosService;
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
    public List<LivrosModel> buscaTodosContatos(){
        return livrosService.buscarTodos();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping(path = "/registro/{id}")
    public Optional<LivrosModel> buscarContatoPorId(@PathVariable Long id){
        return livrosService.buscarPorId(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public LivrosModel cadastrarNovoContato(@RequestBody LivrosModel livrosModel){
        return livrosService.cadastrar(livrosModel);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/registro/{id}")
    public LivrosModel alteraContato(@PathVariable Long id, @RequestBody LivrosModel livrosModel){
        return livrosService.alterar(id, livrosModel);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/registro/{id}")
    public void deletaContato(@PathVariable Long id){
        livrosService.deletar(id);
    }
    }


