package com.backend.lanchessenac.entity;

import com.backend.lanchessenac.dto.FuncionarioDto;
import com.backend.lanchessenac.enums.CargoEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo", nullable = false)
    private CargoEnum cargo;


    public Funcionario(FuncionarioDto funcionarioDto) {
        this.nome = funcionarioDto.nome();
        this.cpf = funcionarioDto.cpf();
        this.cargo = funcionarioDto.cargo();
    }

}
