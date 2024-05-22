package com.backend.lanchessenac.service;

import com.backend.lanchessenac.dto.FuncionarioDto;
import com.backend.lanchessenac.entity.Funcionario;
import com.backend.lanchessenac.exception.ConflictException;
import com.backend.lanchessenac.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Valid
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Transactional(rollbackFor = Exception.class)
    public void saveNewFuncionario(@NotNull FuncionarioDto funcionarioDto) {

        checkIfNameFuncionarioWasExists(funcionarioDto.nome());

        funcionarioRepository.save(new Funcionario(funcionarioDto));
    }

    @Transactional(rollbackFor = Exception.class)
    public void checkIfNameFuncionarioWasExists(String name) {
        if (funcionarioRepository.existsByNomeIgnoreCase(name)) {
            throw new ConflictException("Já existe um Funcionário cadastrado com esse nome");
        }
    }

}
