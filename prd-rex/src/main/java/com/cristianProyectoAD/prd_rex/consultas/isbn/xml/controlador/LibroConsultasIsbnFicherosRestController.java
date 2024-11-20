package com.cristianProyectoAD.prd_rex.consultas.isbn.xml.controlador;

import com.cristianProyectoAD.prd_rex.consultas.isbn.xml.excepcion.LibroNotFoundException;
import com.cristianProyectoAD.prd_rex.consultas.isbn.xml.servicio.LibroIsbnServiceFicheros;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/prd-rex/libros/consulta/ficheros/")
public class LibroConsultasIsbnFicherosRestController {

    private final LibroIsbnServiceFicheros libroIsbnServiceFicheros;

    public LibroConsultasIsbnFicherosRestController(LibroIsbnServiceFicheros libroIsbnServiceFicheros) {
        this.libroIsbnServiceFicheros = libroIsbnServiceFicheros;
    }

    @GetMapping("isbn/{isbn}")
    public ResponseEntity<LibroDTO> getLibroByIsbnFromXml(@PathVariable String isbn) {
        try {
            LibroDTO libro = libroIsbnServiceFicheros.getLibroByIsbn(isbn, "prd-rex/libros.xml");
            return ResponseEntity.ok(libro);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ExceptionHandler(LibroNotFoundException.class)
    public ResponseEntity<String> handleLibroNotFoundException(LibroNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
