package br.edu.uepb.exercicio2.controller;

import java.util.List;
import java.util.Optional;

import br.edu.uepb.exercicio2.domain.Aluno;
import br.edu.uepb.exercicio2.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/alunos")
@Api(value = "Exercicio2")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    @ApiOperation(value = "Obtém uma lista de alunos")
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtém um aluno a partir do ID")
    public Optional<Aluno> getAlunoById(@PathVariable Long id) {
        return alunoRepository.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Cria um aluno")
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um aluno")
    public Aluno updateAluno(@PathVariable("id") Long id, @RequestBody Aluno alunoRequest) {
        Aluno aluno = alunoRepository.getById(id);
        aluno.setNome(alunoRequest.getNome());
        aluno.setMatricula(alunoRequest.getMatricula());
        aluno.setEmail(alunoRequest.getEmail());
        aluno.setTurmas(aluno.getTurmas());
        return alunoRepository.save(aluno);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remove um aluno")
    public void deleteAluno(@PathVariable Long id) {
        alunoRepository.delete(alunoRepository.findById(id).get());
    }

}