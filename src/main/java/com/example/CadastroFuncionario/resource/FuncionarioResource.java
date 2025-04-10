package com.example.CadastroFuncionario.resource;

import com.example.CadastroFuncionario.entities.Funcionarios;
import com.example.CadastroFuncionario.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {
    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<Funcionarios>> findAll() {
        List<Funcionarios> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionarios> findById(@PathVariable Long id) {
        Funcionarios list = service.findById(id);
        return ResponseEntity.ok().body(list);
    }
}
