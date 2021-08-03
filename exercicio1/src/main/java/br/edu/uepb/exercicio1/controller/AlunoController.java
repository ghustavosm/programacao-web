package br.edu.uepb.exercicio1.controller;

import java.util.List;
import java.util.Optional;

import br.edu.uepb.exercicio1.domain.Aluno;
import br.edu.uepb.exercicio1.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> getAlunoById(@PathVariable Long id) {
        return alunoRepository.findById(id);
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable("id") Long id, @RequestBody Aluno alunoRequest) {
        Aluno aluno = alunoRepository.getById(id);
        aluno.setNome(alunoRequest.getNome());
        aluno.setMatricula(alunoRequest.getMatricula());
        aluno.setEmail(alunoRequest.getEmail());
        aluno.setTurmas(aluno.getTurmas());
        return alunoRepository.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunoRepository.delete(alunoRepository.findById(id).get());
    }

}