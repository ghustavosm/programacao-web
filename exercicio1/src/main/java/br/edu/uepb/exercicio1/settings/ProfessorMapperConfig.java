package br.edu.uepb.exercicio1.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.uepb.exercicio1.mapper.ProfessorMapper;

@Configuration
public class ProfessorMapperConfig {
    
    @Bean
    public ModelMapper professorModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ProfessorMapper professorMapper() {
        return new ProfessorMapper();
    }

}