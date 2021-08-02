package br.edu.uepb.exercicio1.controller;

import java.util.List;
import java.util.Optional;

import br.edu.uepb.exercicio1.domain.Turma;
import br.edu.uepb.exercicio1.repository.TurmaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public List<Turma> getTurmas() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Turma> getTurmaById(@PathVariable Long id) {
        return turmaRepository.findById(id);
    }

    @PostMapping
    public Turma createTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @PutMapping("/{id}")
    public Turma updateTurma(@PathVariable("id") Long id, @RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @DeleteMapping("/{id}")
    public void deleteTurma(@PathVariable Long id) {
        turmaRepository.delete(turmaRepository.findById(id).get());
    }

}