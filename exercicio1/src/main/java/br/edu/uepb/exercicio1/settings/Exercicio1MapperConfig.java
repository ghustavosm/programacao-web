package br.edu.uepb.exercicio1.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.uepb.exercicio1.mapper.UserMapper;
import br.edu.uepb.exercicio1.mapper.AlunoMapper;
import br.edu.uepb.exercicio1.mapper.ProfessorMapper;
import br.edu.uepb.exercicio1.mapper.TurmaMapper;

@Configuration
public class Exercicio1MapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public AlunoMapper alunoMapper() {
        return new AlunoMapper();
    }

    @Bean
    public ProfessorMapper professorMapper() {
        return new ProfessorMapper();
    }

    @Bean
    public TurmaMapper turmaMapper() {
        return new TurmaMapper();
    }

}