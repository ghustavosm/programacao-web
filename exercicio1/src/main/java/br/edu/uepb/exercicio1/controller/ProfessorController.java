package br.edu.uepb.exercicio1.controller;

import java.util.List;
import java.util.Optional;

import br.edu.uepb.exercicio1.domain.Professor;
import br.edu.uepb.exercicio1.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Professor> getProfessorById(@PathVariable Long id) {
        return professorRepository.findById(id);
    }

    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable("id") Long id, @RequestBody Professor professorRequest) {
        Professor professor = professorRepository.getById(id);
        professor.setNome(professorRequest.getNome());
        professor.setFormacao(professorRequest.getFormacao());
        professor.setMatricula(professorRequest.getMatricula());
        professor.setEmail(professorRequest.getEmail());
        professor.setTurmas(professor.getTurmas());
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorRepository.delete(professorRepository.findById(id).get());
    }
}