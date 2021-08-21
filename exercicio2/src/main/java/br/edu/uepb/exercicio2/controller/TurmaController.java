package br.edu.uepb.exercicio2.controller;

import java.util.List;
import java.util.Optional;

import br.edu.uepb.exercicio2.domain.Turma;
import br.edu.uepb.exercicio2.domain.Aluno;
import br.edu.uepb.exercicio2.domain.Professor;
import br.edu.uepb.exercicio2.repository.TurmaRepository;
import br.edu.uepb.exercicio2.repository.AlunoRepository;
import br.edu.uepb.exercicio2.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/turmas")
@Api(value = "Exercicio2")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    @ApiOperation(value = "Obtém uma lista de turmas")
    public List<Turma> getTurmas() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtém uma turma a partir do ID")
    public Optional<Turma> getTurmaById(@PathVariable Long id) {
        return turmaRepository.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Cria uma turma")
    public Turma createTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma turma")
    public Turma updateTurma(@PathVariable("id") Long id, @RequestBody Turma turmaRequest) {
        Turma turma = turmaRepository.getById(id);
        turma.setNome(turmaRequest.getNome());
        turma.setSala(turmaRequest.getSala());
        turma.setCodigo(turmaRequest.getCodigo());
        turma.setAlunos(turma.getAlunos());
        return turmaRepository.save(turma);
    }

    @PutMapping("/{turmaId}/matricularAluno/{alunoId}")
    @ApiOperation(value = "Matricula um aluno em uma turma")
    public String matricularAluno(@PathVariable("turmaId") Long turmaId, @PathVariable("alunoId") Long alunoId, @RequestBody Turma turmaRequest) {
        Turma turma = turmaRepository.getById(turmaId);
        Aluno aluno = alunoRepository.getById(alunoId);
        //turma.getAlunos().add(aluno);
        aluno.getTurmas().add(turma);
        alunoRepository.save(aluno);
        //turmaRepository.save(turma);
        return "Aluno matriculado com sucesso!";
    }

    @PutMapping("/{turmaId}/vincularProfessor/{professorId}")
    @ApiOperation(value = "Vincula um professor a uma turma")
    public String vincularProfessor(@PathVariable("turmaId") Long turmaId, @PathVariable("professorId") Long professorId, @RequestBody Turma turmaRequest) {
        Turma turma = turmaRepository.getById(turmaId);
        Professor professor = professorRepository.getById(professorId);
        professor.getTurmas().add(turma);
        professorRepository.save(professor);
        return "Professor vinculado com sucesso!";
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remove uma turma")
    public void deleteTurma(@PathVariable Long id) {
        turmaRepository.delete(turmaRepository.findById(id).get());
    }

}