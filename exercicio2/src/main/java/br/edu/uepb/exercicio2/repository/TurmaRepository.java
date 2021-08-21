package br.edu.uepb.exercicio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uepb.exercicio2.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {}