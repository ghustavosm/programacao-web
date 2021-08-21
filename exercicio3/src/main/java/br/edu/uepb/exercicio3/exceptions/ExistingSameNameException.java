package br.edu.uepb.exercicio3.exceptions;

public class ExistingSameNameException extends Exception {
    public ExistingSameNameException(String message) {
        super(message);
    }
}