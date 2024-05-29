package com.backend.lanchessenac.beans;

import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidadorCpf {

    @Bean
    public CPFValidator cpfValidator() {
        return new CPFValidator();
    }

}
