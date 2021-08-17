package br.edu.uepb.exercicio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.uepb.exercicio1.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
}