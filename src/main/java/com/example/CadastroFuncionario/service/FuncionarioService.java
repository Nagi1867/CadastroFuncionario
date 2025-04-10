package com.example.CadastroFuncionario.service;

import com.example.CadastroFuncionario.entities.Funcionarios;
import com.example.CadastroFuncionario.repositories.FuncionarioRepository;
import com.example.CadastroFuncionario.service.services.DatabaseException;
import com.example.CadastroFuncionario.service.services.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Funcionarios insert(Funcionarios obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Funcionarios update(Long id, Funcionarios obj) {
        try {
            Funcionarios entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Funcionarios entity, Funcionarios obj) {
        entity.setNome(obj.getNome());
        entity.setIdentificacao(obj.getIdentificacao());
        entity.setStatus(obj.getStatus());
    }
}
