package com.backend.lanchessenac.controller;

import com.backend.lanchessenac.dto.FuncionarioDto;
import com.backend.lanchessenac.service.FuncionarioService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update/{idFuncionario}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFuncionario(@PathVariable("idFuncionario") Long idFuncionario, @RequestBody FuncionarioDto funcionarioDto) {
        funcionarioService.updateFuncionario(idFuncionario, funcionarioDto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFuncionario(@PathVariable("id") @NotNull Long funcionarioId) {
        funcionarioService.deleteFuncionario(funcionarioId);
    }

    @GetMapping("/list/all")
    public List<FuncionarioDto> listAllFuncionarios() {
        return funcionarioService.listAllFuncionarios();
    }

}
