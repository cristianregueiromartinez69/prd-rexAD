package com.cristianProyectoAD.prd_rex.consultas.isbn.postgresSQL.controlador;

import com.cristianProyectoAD.prd_rex.consultas.isbn.postgresSQL.servicio.LibroIsbnServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para consultar libros en PostgreSQL por ISBN.
 * Proporciona un endpoint para recuperar un libro basado en su ISBN desde la base de datos PostgreSQL.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/prd-rex/libros/consulta/postresSQL")
public class LibroConsultaIsbnPostgresSQLRestController {

    private final LibroIsbnServicePostgres libroIsbnService;

    /**
     * Constructor del controlador.
     *
     * @param libroIsbnService Servicio que maneja las consultas de libros por ISBN en PostgreSQL.
     */
    public LibroConsultaIsbnPostgresSQLRestController(LibroIsbnServicePostgres libroIsbnService) {
        this.libroIsbnService = libroIsbnService;
    }

    /**
     * Endpoint para obtener un libro en PostgreSQL utilizando su ISBN.
     *
     * @param isbn El ISBN del libro.
     * @return ResponseEntity con los datos del libro si se encuentra.
     */
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<LibroDTO> getLibroByIsbn(@PathVariable("isbn") String isbn) {
        return libroIsbnService.getLibroByIsbnPostgres(isbn);
    }
}
