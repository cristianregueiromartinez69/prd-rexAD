package com.cristianProyectoAD.prd_rex.registrolibros.excepcion;

public class DuplicateIsbnException extends RuntimeException {
  public DuplicateIsbnException(String message) {
    super(message);
  }
}
