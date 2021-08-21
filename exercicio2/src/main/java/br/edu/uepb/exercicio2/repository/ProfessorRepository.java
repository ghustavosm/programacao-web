package br.edu.uepb.exercicio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uepb.exercicio2.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {}