package br.edu.uepb.exercicio1.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.uepb.exercicio1.mapper.TurmaMapper;

@Configuration
public class TurmaMapperConfig {
    
    @Bean
    public ModelMapper turmaModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TurmaMapper turmaMapper() {
        return new TurmaMapper();
    }

}