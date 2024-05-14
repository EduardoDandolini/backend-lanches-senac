package com.backend.lanchessenac.controller;

import com.backend.lanchessenac.dto.AdicionalDTO;
import com.backend.lanchessenac.service.AdicionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adicional")
@RequiredArgsConstructor
public class AdicionalController {

    private final AdicionalService adicionalService;

    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody AdicionalDTO dto){
        return ResponseEntity.ok(adicionalService.salvar(dto));
    }

    @GetMapping("/listar/all")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(adicionalService.findAll());
    }

    @GetMapping("/listar/{nome}")
    public ResponseEntity findByNome(@PathVariable String nome){
        return ResponseEntity.ok(adicionalService.findByNome(nome));
    }

    @DeleteMapping("/excluir/{nome}")
    public ResponseEntity excluir(@PathVariable String nome){
        adicionalService.excluir(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizar/{nome}")
    public ResponseEntity atualizar(@PathVariable String nome, @RequestBody AdicionalDTO dto){
        return ResponseEntity.ok(adicionalService.atualizar(nome, dto));
    }
}
