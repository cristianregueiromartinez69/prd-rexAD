package com.cristianProyectoAD.prd_rex.consultas.isbn.postgresSQL.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Servicio encargado de gestionar la consulta de libros en PostgreSQL por ISBN.
 * Se comunica con el cliente de PostgreSQL para obtener los datos del libro basado en el ISBN.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroIsbnServicePostgres {

    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    /**
     * Constructor del servicio.
     *
     * @param postgresSQLPrdClientService Cliente que maneja la comunicación con la base de datos PostgreSQL.
     */
    public LibroIsbnServicePostgres(PostgresSQLPrdClientService postgresSQLPrdClientService) {
        this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    /**
     * Consulta un libro en PostgreSQL utilizando su ISBN.
     *
     * @param isbn El ISBN del libro.
     * @return ResponseEntity con los datos del libro si se encuentra.
     */
    public ResponseEntity<LibroDTO> getLibroByIsbnPostgres(@RequestParam String isbn) {
        ResponseEntity<LibroDTO> responsePostgres = postgresSQLPrdClientService.getLibroByIsbn(isbn);
        return responsePostgres;
    }
}
