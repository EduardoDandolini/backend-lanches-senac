package com.backend.lanchessenac.service;

import com.backend.lanchessenac.dto.AdicionalDTO;
import com.backend.lanchessenac.entity.Adicional;
import com.backend.lanchessenac.exception.ConflictException;
import com.backend.lanchessenac.exception.NotFoundException;
import com.backend.lanchessenac.repository.AdicionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdicionalService {

    private final AdicionalRepository adicionalRepository;

    public Adicional salvar(AdicionalDTO dto){
        Adicional adicionalEncontrado = adicionalRepository.findByNome(dto.nome());
        if (adicionalEncontrado != null && adicionalEncontrado.getNome().equalsIgnoreCase(dto.nome())) {
            throw new ConflictException("Já existe um Adicional com esse nome no banco de dados");
        }

        Adicional adicionalSalvo = Adicional.builder()
                .nome(dto.nome())
                .build();
        return adicionalRepository.save(adicionalSalvo);
    }

    public Adicional findByNome(String nome){
        return adicionalRepository.findByNome(nome);
    }

    public List<Adicional> findAll(){
        return adicionalRepository.findAll();
    }

    public void excluir(String nome){
        Adicional adicional = adicionalRepository.findByNome(nome);

        if (adicional != null) {
            adicionalRepository.delete(adicional);
        }

        throw new RuntimeException("Adicional não encontrado");
    }

    public Adicional atualizar(String nome, AdicionalDTO dto){
        Adicional adicional = adicionalRepository.findByNome(nome);

        if (adicional != null) {
            return Adicional.builder()
                    .nome(dto.nome())
                    .build();
        }
        throw new NotFoundException("Adicional não encontrado");
    }
}
