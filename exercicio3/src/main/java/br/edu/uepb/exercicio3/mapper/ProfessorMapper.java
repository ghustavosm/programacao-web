package br.edu.uepb.exercicio3.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.uepb.exercicio3.domain.Professor;
import br.edu.uepb.exercicio3.dto.ProfessorDTO;

public class ProfessorMapper {

    @Autowired
    private ModelMapper modelMapper;
    
    public ProfessorDTO convertToProfessorDTO(Professor professor) {
        ProfessorDTO professorDTO = modelMapper.map(professor, ProfessorDTO.class);
        return professorDTO;
    }

    public Professor convertFromProfessorDTO(ProfessorDTO professorDTO) {
        Professor professor = modelMapper.map(professorDTO, Professor.class);    
        return professor;
    }

}