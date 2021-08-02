package br.edu.uepb.exercicio1.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "turmas")
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codigo")
    private String codigo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "turmas")
    private Set<Aluno> alunos = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "turmas")
    private Set<Professor> professores = new HashSet<>();

    public Turma(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    @JsonManagedReference
    public Set<Aluno> getAlunos() {
        return alunos;
    }

    @JsonManagedReference
    public Set<Professor> getProfessores() {
        return professores;
    }
    
}