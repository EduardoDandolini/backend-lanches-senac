package com.backend.lanchessenac.service;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import com.backend.lanchessenac.dto.FuncionarioDto;
import com.backend.lanchessenac.entity.Funcionario;
import com.backend.lanchessenac.exception.BadRequestException;
import com.backend.lanchessenac.exception.ConflictException;
import com.backend.lanchessenac.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Valid
@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final CPFValidator cpfValidator;
    private final FuncionarioRepository funcionarioRepository;

    @Transactional(rollbackFor = Exception.class)
    public void saveNewFuncionario(@NotNull FuncionarioDto funcionarioDto) {

        validaCpf(funcionarioDto.cpf());
        checkIfNameFuncionarioWasExists(funcionarioDto.nome());
        checkIfCpfFuncionarioWasExists(funcionarioDto.cpf());

        funcionarioRepository.save(new Funcionario(funcionarioDto));
    }

    @Transactional(rollbackFor = Exception.class)
    public void checkIfNameFuncionarioWasExists(@NotBlank String name) {
        if (funcionarioRepository.existsByNomeIgnoreCase(name)) {
            throw new ConflictException("Já existe um Funcionário cadastrado com esse nome");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void checkIfCpfFuncionarioWasExists(@NotBlank String cpf) {
        if (funcionarioRepository.existsByCpf(cpf)) {
            throw new ConflictException("Já existe um Funcionário cadastrado com esse cpf");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void validaCpf(@NotBlank String cpf) {
        try {
            cpfValidator.assertValid(cpf);
        } catch (InvalidStateException invalidStateException) {
            throw new BadRequestException("CPF inválido - " + invalidStateException.getMessage());
        }
    }

}
