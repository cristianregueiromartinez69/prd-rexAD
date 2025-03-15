package com.cristianProyectoAD.prd_rex.consultas.nombre.postgres.controlador;

import com.cristianProyectoAD.prd_rex.consultas.nombre.postgres.servicio.LibroNombreServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para gestionar consultas relacionadas con los nombres de libros en una base de datos PostgreSQL.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/prd-rex/libros/consulta/postgresSQL")
public class LibroNombrePostgresRestController {

    /** Servicio que proporciona la lógica para las consultas de nombres de libros en PostgreSQL. */
    private final LibroNombreServicePostgres libroNombreServicePostgres;

    /**
     * Constructor de la clase.
     *
     * @param libroNombreServicePostgres el servicio que gestiona las consultas de nombres de libros.
     */
    public LibroNombrePostgresRestController(LibroNombreServicePostgres libroNombreServicePostgres) {
        this.libroNombreServicePostgres = libroNombreServicePostgres;
    }

    /**
     * Endpoint para obtener una lista de libros cuyo nombre coincide con el proporcionado desde la base de datos PostgreSQL.
     *
     * @param nombre el nombre del libro a buscar.
     * @return una respuesta HTTP que contiene una lista de objetos {@link LibroDTO} correspondientes
     *         a los libros encontrados.
     */
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<LibroDTO>> getLibroByNombre(@PathVariable String nombre) {
        return libroNombreServicePostgres.getLibrosPostgresByNombre(nombre);
    }
}
