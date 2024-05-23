package com.backend.lanchessenac.dto;

import com.backend.lanchessenac.enums.CargoEnum;
import jakarta.validation.constraints.NotNull;

public record FuncionarioDto (Long idFuncionario, @NotNull String nome, @NotNull String cpf, @NotNull CargoEnum cargo) {}
