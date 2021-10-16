package br.edu.uepb.example.projetos.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.uepb.example.projetos.domain.Projeto;
import br.edu.uepb.example.projetos.dto.ProjetoDTO;

public class ProjetoMapper {

    @Autowired
    private ModelMapper modelMapper;
    
    public ProjetoDTO convertToProjetoDTO(Projeto projeto) {
        ProjetoDTO projetoDTO = modelMapper.map(projeto, ProjetoDTO.class);
        return projetoDTO;
    }

    public Projeto convertFromProjetoDTO(ProjetoDTO projetoDTO) {
        Projeto projeto = modelMapper.map(projetoDTO, Projeto.class);    
        return projeto;
    }

}