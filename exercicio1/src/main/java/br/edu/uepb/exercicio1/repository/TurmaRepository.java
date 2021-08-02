package br.edu.uepb.exercicio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uepb.exercicio1.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {}