package com.backend.lanchessenac.service;

import com.backend.lanchessenac.dto.AdicionalDTO;
import com.backend.lanchessenac.entity.Adicional;
import com.backend.lanchessenac.exception.ConflictException;
import com.backend.lanchessenac.exception.NotFoundException;
import com.backend.lanchessenac.repository.AdicionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdicionalService {

    private final AdicionalRepository adicionalRepository;

    @Transactional
    public Adicional salvar(AdicionalDTO dto){
       Adicional adicionalExistente = adicionalRepository.findByNome(dto.nome());
        if (adicionalExistente != null) {
            throw new ConflictException("Já existe um Adicional com esse nome no banco de dados");
        }

        Adicional adicionalSalvo = Adicional.builder()
                .nome(dto.nome())
                .build();
        return adicionalRepository.save(adicionalSalvo);
    }

    @Transactional
    public Adicional findByNome(String nome){
        return adicionalRepository.findByNome(nome);
    }

    @Transactional
    public List<Adicional> findAll(){
        return adicionalRepository.findAll();
    }

    @Transactional
    public void excluir(String nome){
        Adicional adicional = adicionalRepository.findByNome(nome);

        if (adicional == null) {
            throw new NotFoundException("Adicional não encontrado");
        }
        adicionalRepository.delete(adicional);
    }

    @Transactional
    public Adicional atualizar(String nome, AdicionalDTO dto){
        Adicional adicional = adicionalRepository.findByNome(nome);

        if (adicional == null) {
            throw new NotFoundException("Adicional não encontrado");
        }
        if (adicional.getNome().equalsIgnoreCase(dto.nome())) {
            throw new ConflictException("Já existe um Adicional com esse nome no banco de dados");
        }
        adicional.setNome(dto.nome());
        return adicionalRepository.save(adicional);

    }
}
