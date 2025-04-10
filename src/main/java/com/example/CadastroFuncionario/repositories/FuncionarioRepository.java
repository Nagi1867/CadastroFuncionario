package com.example.CadastroFuncionario.repositories;

import com.example.CadastroFuncionario.entities.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long> {
}
