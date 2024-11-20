package com.cristianProyectoAD.prd_rex.consultas.autor.postgres.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de gestionar la consulta de libros en PostgreSQL por autor.
 * Se comunica con el cliente de PostgreSQL para obtener los datos de los libros basados en el autor.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroAutorServicePostgres {

    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    /**
     * Constructor del servicio.
     *
     * @param postgresSQLPrdClientService Cliente que maneja la comunicación con la base de datos PostgreSQL.
     */
    public LibroAutorServicePostgres(PostgresSQLPrdClientService postgresSQLPrdClientService) {
        this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    /**
     * Consulta libros en PostgreSQL utilizando el nombre de un autor.
     *
     * @param autor El nombre del autor.
     * @return ResponseEntity con la lista de libros del autor si se encuentran.
     */
    public ResponseEntity<List<LibroDTO>> getLibroByAutor(String autor) {
        return postgresSQLPrdClientService.getLibroByAutor(autor);
    }
}
