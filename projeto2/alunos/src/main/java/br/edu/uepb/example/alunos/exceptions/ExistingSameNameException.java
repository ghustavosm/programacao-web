package br.edu.uepb.example.alunos.exceptions;

public class ExistingSameNameException extends Exception {
    public ExistingSameNameException(String message) {
        super(message);
    }
}