package br.edu.uepb.example.projetos.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.uepb.example.projetos.mapper.ProjetoMapper;

@Configuration
public class ProjetosMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ProjetoMapper projetoMapper() {
        return new ProjetoMapper();
    }

}