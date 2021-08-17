package br.edu.uepb.exercicio1.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.uepb.exercicio1.mapper.AlunoMapper;

@Configuration
public class AlunoMapperConfig {
    
    @Bean
    public ModelMapper alunoModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public AlunoMapper alunoMapper() {
        return new AlunoMapper();
    }

}