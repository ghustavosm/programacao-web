package br.edu.uepb.exercicio1.exceptions;

public class ExistingSameNameException extends Exception {
    public ExistingSameNameException(String message) {
        super(message);
    }
}