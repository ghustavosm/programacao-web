package br.edu.uepb.exercicio3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.uepb.exercicio3.domain.Professor;
import br.edu.uepb.exercicio3.exceptions.ExistingSameNameException;
import br.edu.uepb.exercicio3.repository.ProfessorRepository;
import javassist.NotFoundException;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor createProfessor(Professor professor) throws ExistingSameNameException {
        if (professorRepository.findByNome(professor.getNome()).isPresent())
            throw new ExistingSameNameException("Já existe um professor com esse nome!");
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(Long id, Professor professor) {
        professor.setId(id);
        return professorRepository.save(professor);
    }

    public List<Professor> listAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor findById(Long id) throws NotFoundException {
        return professorRepository.findById(id).orElseThrow(() -> new NotFoundException("Não existe um professor com esse identificador!"));
    }

    public void deleteProfessor(Long id) {
        Professor professorToDelete = professorRepository.findById(id).get();
        professorRepository.delete(professorToDelete);
    }
}