package com.backend.lanchessenac.service;

import com.backend.lanchessenac.dto.FuncionarioDto;
import com.backend.lanchessenac.entity.Funcionario;
import com.backend.lanchessenac.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Valid
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Transactional
    public void saveNewFuncionario(@NotNull FuncionarioDto funcionarioDto) {
        funcionarioRepository.save(new Funcionario(funcionarioDto));
    }

}
