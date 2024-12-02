package com.cristianProyectoAD.prd_rex.consultas.isbn.xml.controlador;

import com.cristianProyectoAD.prd_rex.consultas.isbn.xml.excepcion.LibroNotFoundException;
import com.cristianProyectoAD.prd_rex.consultas.isbn.xml.servicio.LibroIsbnServiceFicheros;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Controlador encargado de gestionar las consultas de libros por ISBN desde un archivo XML.
 * Utiliza el servicio `LibroIsbnServiceFicheros` para obtener los datos del libro desde un fichero XML.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/prd-rex/libros/consulta/ficheros/")
public class LibroConsultasIsbnFicherosRestController {

    private final LibroIsbnServiceFicheros libroIsbnServiceFicheros;

    /**
     * Constructor del controlador.
     *
     * @param libroIsbnServiceFicheros Servicio encargado de gestionar la consulta de libros desde archivos XML.
     */
    public LibroConsultasIsbnFicherosRestController(LibroIsbnServiceFicheros libroIsbnServiceFicheros) {
        this.libroIsbnServiceFicheros = libroIsbnServiceFicheros;
    }

    /**
     * Consulta un libro utilizando su ISBN desde un archivo XML.
     *
     * @param isbn El ISBN del libro.
     * @return ResponseEntity con los datos del libro si se encuentra.
     */
    @GetMapping("isbn/{isbn}")
    public ResponseEntity<LibroDTO> getLibroByIsbnFromXml(@PathVariable String isbn) {
        try {
            String pathWindows = "C:/Users/crm23/Downloads/prd-rex/prd-rex/libros.xml";
            String pathLinux = "/home/dam/Desktop/DAM2/Acceso a Datos/prd-rexAD/prd-rex/libros.xml";
            LibroDTO libro = libroIsbnServiceFicheros.getLibroByIsbn(isbn, pathLinux);
            return ResponseEntity.ok(libro);
        } catch (IOException | XMLStreamException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Maneja excepciones de tipo `LibroNotFoundException`.
     *
     * @param ex La excepción que se ha lanzado cuando el libro no se encuentra.
     * @return ResponseEntity con un mensaje de error y el código HTTP 404.
     */
    @ExceptionHandler(LibroNotFoundException.class)
    public ResponseEntity<String> handleLibroNotFoundException(LibroNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
