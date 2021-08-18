package br.edu.uepb.exercicio1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.uepb.exercicio1.domain.Turma;
//import br.edu.uepb.exercicio1.domain.Aluno;
//import br.edu.uepb.exercicio1.domain.Professor;
import br.edu.uepb.exercicio1.exceptions.ExistingSameNameException;
import br.edu.uepb.exercicio1.repository.TurmaRepository;
//import br.edu.uepb.exercicio1.repository.AlunoRepository;
//import br.edu.uepb.exercicio1.repository.ProfessorRepository;
import javassist.NotFoundException;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    /*@Autowired
    private AlunoRepository alunoRepository;*/

    /*@Autowired
    private ProfessorRepository professorRepository;*/

    public Turma createTurma(Turma turma) throws ExistingSameNameException {
        if (turmaRepository.findByNome(turma.getNome()).isPresent())
            throw new ExistingSameNameException("Já existe uma turma com esse nome!");
        return turmaRepository.save(turma);
    }

    public Turma updateTurma(Long id, Turma turma) {
        turma.setId(id);
        return turmaRepository.save(turma);
    }

    public List<Turma> listAllTurmas() {
        return turmaRepository.findAll();
    }

    public Turma findById(Long id) throws NotFoundException {
        return turmaRepository.findById(id).orElseThrow(() -> new NotFoundException("Não existe uma turma com esse identificador!"));
    }

    public void deleteTurma(Long id) {
        Turma turmaToDelete = turmaRepository.findById(id).get();
        turmaRepository.delete(turmaToDelete);
    }

    /*public void matriculaAluno(Long turmaId, Long alunoId) {
        Turma turma = turmaRepository.getById(turmaId);
        Aluno aluno = alunoRepository.getById(alunoId);
        //turma.getAlunos().add(aluno);
        aluno.getTurmas().add(turma);
        alunoRepository.save(aluno);
        //turmaRepository.save(turma);
    }*/
}