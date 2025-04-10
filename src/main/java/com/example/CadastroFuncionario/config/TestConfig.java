package com.example.CadastroFuncionario.config;

import com.example.CadastroFuncionario.entities.Funcionarios;
import com.example.CadastroFuncionario.enums.Status;
import com.example.CadastroFuncionario.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private FuncionarioRepository repository;


    @Override
    public void run(String... args) throws Exception {
        Funcionarios funcionario = new Funcionarios(null, "Giuseppi", "94948", Status.ATIVO);
        repository.save(funcionario);
    }
}
