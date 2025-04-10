package com.example.CadastroFuncionario.service;

import com.example.CadastroFuncionario.entities.Funcionarios;
import com.example.CadastroFuncionario.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
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

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Funcionarios update(Long id, Funcionarios obj) {
        Funcionarios entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Funcionarios entity, Funcionarios obj) {
        entity.setNome(obj.getNome());
        entity.setIdentificacao(obj.getIdentificacao());
        entity.setStatus(obj.getStatus());
    }
}
