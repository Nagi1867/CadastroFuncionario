package com.example.CadastroFuncionario.service;

import com.example.CadastroFuncionario.entities.Funcionarios;
import com.example.CadastroFuncionario.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionarios> findAll() {
        return repository.findAll();
    }

    public Funcionarios findById(Long id) {
        Optional<Funcionarios> obj = repository.findById(id);
        return obj.get();
    }

    public Funcionarios insert(Funcionarios obj) {
        return repository.save(obj);
    }
}
