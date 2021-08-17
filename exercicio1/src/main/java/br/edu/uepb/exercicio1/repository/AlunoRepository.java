package br.edu.uepb.exercicio1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uepb.exercicio1.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByNome(String nome);

}