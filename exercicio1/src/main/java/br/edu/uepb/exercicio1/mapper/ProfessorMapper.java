package br.edu.uepb.exercicio1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.uepb.exercicio1.domain.Professor;
import br.edu.uepb.exercicio1.dto.ProfessorDTO;

public class ProfessorMapper {

    @Autowired
    private ModelMapper professorModelMapper;
    
    public ProfessorDTO convertToProfessorDTO(Professor professor) {
        ProfessorDTO professorDTO = professorModelMapper.map(professor, ProfessorDTO.class);
        return professorDTO;
    }

    public Professor convertFromProfessorDTO(ProfessorDTO professorDTO) {
        Professor professor = professorModelMapper.map(professorDTO, Professor.class);    
        return professor;
    }

}