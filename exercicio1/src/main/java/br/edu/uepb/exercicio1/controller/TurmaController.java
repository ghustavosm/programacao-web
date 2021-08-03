package br.edu.uepb.exercicio1.controller;

import java.util.List;
import java.util.Optional;

import br.edu.uepb.exercicio1.domain.Turma;
import br.edu.uepb.exercicio1.domain.Aluno;
import br.edu.uepb.exercicio1.domain.Professor;
import br.edu.uepb.exercicio1.repository.TurmaRepository;
import br.edu.uepb.exercicio1.repository.AlunoRepository;
import br.edu.uepb.exercicio1.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

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
    public Turma updateTurma(@PathVariable("id") Long id, @RequestBody Turma turmaRequest) {
        Turma turma = turmaRepository.getById(id);
        turma.setNome(turmaRequest.getNome());
        turma.setSala(turmaRequest.getSala());
        turma.setCodigo(turmaRequest.getCodigo());
        turma.setAlunos(turma.getAlunos());
        return turmaRepository.save(turma);
    }

    @PutMapping("/{turmaId}/matricularAluno/{alunoId}")
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
    public String vincularProfessor(@PathVariable("turmaId") Long turmaId, @PathVariable("professorId") Long professorId, @RequestBody Turma turmaRequest) {
        Turma turma = turmaRepository.getById(turmaId);
        Professor professor = professorRepository.getById(professorId);
        professor.getTurmas().add(turma);
        professorRepository.save(professor);
        return "Professor vinculado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public void deleteTurma(@PathVariable Long id) {
        turmaRepository.delete(turmaRepository.findById(id).get());
    }

}