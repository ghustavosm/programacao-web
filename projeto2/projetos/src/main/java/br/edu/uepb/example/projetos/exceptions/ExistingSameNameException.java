package br.edu.uepb.example.projetos.exceptions;

public class ExistingSameNameException extends Exception {
    public ExistingSameNameException(String message) {
        super(message);
    }
}