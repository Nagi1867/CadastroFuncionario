package com.example.CadastroFuncionario.resource;

import com.example.CadastroFuncionario.entities.Funcionarios;
import com.example.CadastroFuncionario.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Funcionarios> insert(@RequestBody Funcionarios obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
