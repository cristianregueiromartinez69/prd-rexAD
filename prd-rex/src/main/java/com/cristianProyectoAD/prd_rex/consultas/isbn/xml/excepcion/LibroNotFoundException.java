package com.cristianProyectoAD.prd_rex.consultas.isbn.xml.excepcion;

public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(String message) {
        super(message);
    }
}
