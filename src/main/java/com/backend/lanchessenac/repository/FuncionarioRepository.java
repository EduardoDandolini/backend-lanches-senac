package com.backend.lanchessenac.repository;

import com.backend.lanchessenac.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
