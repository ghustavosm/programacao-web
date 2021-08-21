package br.edu.uepb.exercicio2.controller;

import java.util.List;
import java.util.Optional;

import br.edu.uepb.exercicio2.domain.Professor;
import br.edu.uepb.exercicio2.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/professores")
@Api(value = "Exercicio2")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    @ApiOperation(value = "Obtém uma lista de professores")
    public List<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtém um professor a partir do ID")
    public Optional<Professor> getProfessorById(@PathVariable Long id) {
        return professorRepository.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Cria um professor")
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um professor")
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
    @ApiOperation(value = "Remove um professor")
    public void deleteProfessor(@PathVariable Long id) {
        professorRepository.delete(professorRepository.findById(id).get());
    }
}