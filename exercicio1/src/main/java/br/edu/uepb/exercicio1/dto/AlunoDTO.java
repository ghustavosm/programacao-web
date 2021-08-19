package br.edu.uepb.exercicio1.dto;

import java.util.Set;

import lombok.Data;

@Data
public class AlunoDTO {
    
    private Long id;
    private String nome;
    private String matricula;
    private String email;
    private String username;
    private String password;
    private Set<TurmaDTO> turmas;

}