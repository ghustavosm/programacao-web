package br.edu.uepb.exercicio1.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.uepb.exercicio1.domain.Aluno;
//import br.edu.uepb.exercicio1.dto.AlunoDTO;
//import br.edu.uepb.exercicio1.mapper.AlunoMapper;
//import br.edu.uepb.exercicio1.services.AlunoService;
import br.edu.uepb.exercicio1.repository.AlunoRepository;

import br.edu.uepb.exercicio1.domain.Professor;
//import br.edu.uepb.exercicio1.dto.ProfessorDTO;
//import br.edu.uepb.exercicio1.mapper.ProfessorMapper;
//import br.edu.uepb.exercicio1.services.ProfessorService;
import br.edu.uepb.exercicio1.repository.ProfessorRepository;

import br.edu.uepb.exercicio1.domain.Turma;
import br.edu.uepb.exercicio1.dto.TurmaDTO;
import br.edu.uepb.exercicio1.mapper.TurmaMapper;
import br.edu.uepb.exercicio1.services.TurmaService;
import br.edu.uepb.exercicio1.repository.TurmaRepository;

import br.edu.uepb.exercicio1.dto.GenericResponseErrorDTO;
import br.edu.uepb.exercicio1.exceptions.ExistingSameNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/turmas", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
@Api(value = "Exercicio1")
public class TurmaController {

    @Autowired
    private TurmaService turmaService; 

    @Autowired
    private TurmaMapper turmaMapper;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository; 

    @Autowired
    private TurmaRepository turmaRepository; 

    @GetMapping
    @ApiOperation(value = "Obtém uma lista de turmas")
    public List<TurmaDTO> getTurmas() {
        List<Turma> turmas = turmaService.listAllTurmas();
        return turmas.stream()
                        .map(turmaMapper::convertToTurmaDTO)
                        .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtém uma turma a partir do ID")
    public ResponseEntity<?> getTurmaById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(turmaMapper.convertToTurmaDTO(turmaService.findById(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
    }

    @PostMapping
    @ApiOperation(value = "Cria uma turma")
    public ResponseEntity<?> createTurma(@RequestBody TurmaDTO turmaDTO) {
        try {
            Turma turma = turmaMapper.convertFromTurmaDTO(turmaDTO);
            return new ResponseEntity<>(turmaService.createTurma(turma), HttpStatus.CREATED);
        } catch (ExistingSameNameException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma turma")
    public TurmaDTO updateTurma(@PathVariable("id") Long id, @RequestBody TurmaDTO turmaDTO) {
        Turma turma = turmaMapper.convertFromTurmaDTO(turmaDTO);
        return turmaMapper.convertToTurmaDTO(turmaService.updateTurma(id, turma));
    }
    /*public Turma updateTurma(@PathVariable("id") Long id, @RequestBody Turma turmaRequest) {
        Turma turma = turmaRepository.getById(id);
        turma.setNome(turmaRequest.getNome());
        turma.setSala(turmaRequest.getSala());
        turma.setCodigo(turmaRequest.getCodigo());
        turma.setAlunos(turma.getAlunos());
        return turmaRepository.save(turma);
    }*/

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
        turmaService.deleteTurma(id);
    }

}