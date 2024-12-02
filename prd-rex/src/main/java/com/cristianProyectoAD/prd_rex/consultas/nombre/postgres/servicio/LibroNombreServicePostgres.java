package com.cristianProyectoAD.prd_rex.consultas.nombre.postgres.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar las consultas relacionadas con nombres de libros en una base de datos PostgreSQL.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroNombreServicePostgres {

    /** Cliente que proporciona la comunicación con la base de datos PostgreSQL. */
    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    /**
     * Constructor de la clase.
     *
     * @param postgresSQLPrdClientService el cliente para interactuar con PostgreSQL.
     */
    public LibroNombreServicePostgres(PostgresSQLPrdClientService postgresSQLPrdClientService) {
       this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    /**
     * Obtiene una lista de libros desde PostgreSQL cuyo nombre coincide con el especificado.
     *
     * @param nombre el nombre del libro a buscar.
     * @return una respuesta HTTP que contiene una lista de objetos {@link LibroDTO} correspondientes
     *         a los libros encontrados.
     */
    public ResponseEntity<List<LibroDTO>> getLibrosPostgresByNombre(String nombre) {
        return postgresSQLPrdClientService.getLibroByNombre(nombre);
    }




}
