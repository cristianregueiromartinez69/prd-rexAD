package com.cristianProyectoAD.prd_rex.consultas.isbn.xml.excepcion;

/**
 * Clase para manejar la excepcion de no encontrar un libro en el sistema de ficheros por isbn
 * @author cristian
 * @version 1.0
 */
public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(String message) {
        super(message);
    }
}
