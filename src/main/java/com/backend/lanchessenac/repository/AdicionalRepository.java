package com.backend.lanchessenac.repository;

import com.backend.lanchessenac.entity.Adicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdicionalRepository extends JpaRepository<Adicional,Long> {

    Adicional findByNome(String nome);
}
