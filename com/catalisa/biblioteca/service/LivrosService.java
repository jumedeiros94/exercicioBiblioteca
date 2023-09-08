package com.catalisa.biblioteca.service;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

@Autowired
LivrosRepository livrosRepository;


    public List<LivrosModel> buscarTodos() {
        return livrosRepository.findAll();
    }


    // método que busca um livro pelo id
    public Optional<LivrosModel> buscarPorId(Long id) {
        return livrosRepository.findById(id);
    }


    // método que cadastra um novo livro no banco
    public LivrosModel cadastrar(LivrosModel livrosModel) {
        return livrosRepository.save(livrosModel);
    }


    // método para alterar um livro já existente
    public LivrosModel alterar(Long id, LivrosModel livrosModel) {
        LivrosModel registro = buscarPorId(id).get();


        if (livrosModel.getNome() != null) {
            registro.setNome(livrosModel.getNome());
        }
        if (livrosModel.getAutor() != null) {
            registro.setAutor(livrosModel.getAutor());
        }
        if (livrosModel.getDataDeLancamento() != null) {
            registro.setDataDeLancamento(livrosModel.getDataDeLancamento());
        }
        if (livrosModel.getCodigoDoLivro() != null) {
            registro.setCodigoDoLivro(livrosModel.getCodigoDoLivro());
        }
        return livrosRepository.save(registro);
    }

    public void deletar(Long id) {
        livrosRepository.deleteById(id);
    }
}
