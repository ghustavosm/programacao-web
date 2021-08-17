package br.edu.uepb.exercicio1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.uepb.exercicio1.domain.Aluno;
import br.edu.uepb.exercicio1.dto.AlunoDTO;

public class AlunoMapper {

    @Autowired
    private ModelMapper alunoModelMapper;
    
    public AlunoDTO convertToAlunoDTO(Aluno aluno) {
        AlunoDTO alunoDTO = alunoModelMapper.map(aluno, AlunoDTO.class);
        return alunoDTO;
    }

    public Aluno convertFromAlunoDTO(AlunoDTO alunoDTO) {
        Aluno aluno = alunoModelMapper.map(alunoDTO, Aluno.class);    
        return aluno;
    }

}