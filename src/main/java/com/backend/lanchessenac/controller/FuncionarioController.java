package com.backend.lanchessenac.controller;

import com.backend.lanchessenac.dto.FuncionarioDto;
import com.backend.lanchessenac.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewFuncionario(@RequestBody FuncionarioDto funcionarioDto) {
        funcionarioService.saveNewFuncionario(funcionarioDto);
    }

}
