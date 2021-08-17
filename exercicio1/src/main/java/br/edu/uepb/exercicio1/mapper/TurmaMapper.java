package br.edu.uepb.exercicio1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.uepb.exercicio1.domain.Turma;
import br.edu.uepb.exercicio1.dto.TurmaDTO;

public class TurmaMapper {

    @Autowired
    private ModelMapper turmaModelMapper;
    
    public TurmaDTO convertToTurmaDTO(Turma turma) {
        TurmaDTO turmaDTO = turmaModelMapper.map(turma, TurmaDTO.class);
        return turmaDTO;
    }

    public Turma convertFromTurmaDTO(TurmaDTO turmaDTO) {
        Turma turma = turmaModelMapper.map(turmaDTO, Turma.class);    
        return turma;
    }

}