package br.edu.uepb.exercicio3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponseErrorDTO {
    private String error;
}