package br.edu.uepb.exercicio3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.uepb.exercicio3.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
}