package com.catalisa.biblioteca.controller;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class LivrosController {

@Autowired
LivrosService livrosService;


    @GetMapping(path = "/registro")
    public List<LivrosModel> buscaTodosContatos(){
        return livrosService.buscarTodos();
    }

    @GetMapping(path = "/registro/{id}")
    public Optional<LivrosModel> buscarContatoPorId(@PathVariable Long id){
        return livrosService.buscarPorId(id);
    }

    @PostMapping(path = "/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public LivrosModel cadastrarNovoContato(@RequestBody LivrosModel livrosModel){
        return livrosService.cadastrar(livrosModel);
    }


    @PutMapping(path = "/registro/{id}")
    public LivrosModel alteraContato(@PathVariable Long id, @RequestBody LivrosModel livrosModel){
        return livrosService.alterar(id, livrosModel);
    }



    @DeleteMapping(path = "/registro/{id}")
    public void deletaContato(@PathVariable Long id){
        livrosService.deletar(id);
    }

}


