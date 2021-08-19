package br.edu.uepb.exercicio1.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.uepb.exercicio1.domain.Turma;
import br.edu.uepb.exercicio1.dto.TurmaDTO;
import br.edu.uepb.exercicio1.mapper.TurmaMapper;
import br.edu.uepb.exercicio1.services.TurmaService;

import br.edu.uepb.exercicio1.dto.GenericResponseErrorDTO;
import br.edu.uepb.exercicio1.exceptions.ExistingSameNameException;
import br.edu.uepb.exercicio1.exceptions.NaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma turma")
    public String updateTurma(@PathVariable("id") Long id, @RequestBody TurmaDTO turmaDTO) throws NaoEncontradoException {
        Turma turma = turmaMapper.convertFromTurmaDTO(turmaDTO);
        turmaService.updateTurma(id, turma);
        //return turmaMapper.convertToTurmaDTO(turmaService.updateTurma(id, turma));
        return "Aluno atualizado com sucesso!";
    }

    @Transactional
    @PutMapping("/{turmaId}/matricularAluno/{alunoId}")
    @ApiOperation(value = "Matricula um aluno em uma turma")
    public String matricularAluno(@PathVariable("turmaId") Long turmaId, @PathVariable("alunoId") Long alunoId, @RequestBody TurmaDTO turmaDTO) throws NaoEncontradoException {
        Turma turma = turmaMapper.convertFromTurmaDTO(turmaDTO);
        turmaService.matriculaAluno(turmaId, alunoId, turma);
        return "Aluno matriculado com sucesso!";
    }

    @Transactional
    @PutMapping("/{turmaId}/vincularProfessor/{professorId}")
    @ApiOperation(value = "Matricula um aluno em uma turma")
    public String vincularProfessor(@PathVariable("turmaId") Long turmaId, @PathVariable("professorId") Long professorId, @RequestBody TurmaDTO turmaDTO) throws NaoEncontradoException {
        Turma turma = turmaMapper.convertFromTurmaDTO(turmaDTO);
        turmaService.vinculaProfessor(turmaId, professorId, turma);
        return "Professor vinculado com sucesso!";
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remove uma turma")
    public void deleteTurma(@PathVariable Long id) {
        turmaService.deleteTurma(id);
    }

}