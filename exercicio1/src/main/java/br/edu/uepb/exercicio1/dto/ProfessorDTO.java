package br.edu.uepb.exercicio1.dto;

import java.util.Set;

import lombok.Data;

@Data
public class ProfessorDTO {
    
    private Long id;
    private String nome;
    private String formacao;
    private String matricula;
    private String email;
    private Set<TurmaDTO> turmas;

}
