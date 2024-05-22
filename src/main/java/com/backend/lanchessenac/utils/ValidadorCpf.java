package com.backend.lanchessenac.utils;

import com.backend.lanchessenac.exception.BadRequestException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Valid
@Component
public class ValidadorCpf {

    public boolean checkIfCpfIsValid(@NotBlank String cpf) {
        cpf = onlyDigitsInCpf(cpf);
        if (cpf.length() < 11 || cpf.length() > 11) {
            throw new BadRequestException("CPF inválido , tamanho do cpf informado é de " + cpf.length());
        }
    }

    public String onlyDigitsInCpf(@NotBlank String cpf) {
        return cpf.replaceAll("[^0-9]+", "");
    }

}
