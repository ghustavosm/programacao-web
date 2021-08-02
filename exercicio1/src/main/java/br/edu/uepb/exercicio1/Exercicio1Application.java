package br.edu.uepb.exercicio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.uepb.exercicio1.domain.Aluno;
import br.edu.uepb.exercicio1.domain.Turma;
import br.edu.uepb.exercicio1.domain.Professor;
import br.edu.uepb.exercicio1.repository.AlunoRepository;
import br.edu.uepb.exercicio1.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Exercicio1Application implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Exercicio1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        turmaRepository.deleteAllInBatch();
        alunoRepository.deleteAllInBatch();

        Turma turma = new Turma("WEB", "1234567");

		Professor professor = new Professor("Ramon", "123456781", "ramon@gmail.com");

        Aluno aluno1 = new Aluno("Gustavo", "123456782", "ghustavosm@gmail.com");
        Aluno aluno2 = new Aluno("Luis Thiago", "123456783", "luisthiago@gmail.com");

		turma.getProfessores().add(professor);
		professor.getTurmas().add(turma);

        turma.getAlunos().add(aluno1);
        turma.getAlunos().add(aluno2);
        aluno1.getTurmas().add(turma);
        aluno2.getTurmas().add(turma);

        turmaRepository.save(turma);

    }
	
}