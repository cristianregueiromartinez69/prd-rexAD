package com.cristianProyectoAD.prd_rex.consultas.fecharegistro.postgres.controlador;

import com.cristianProyectoAD.prd_rex.consultas.fecharegistro.postgres.servicio.LibroFechaRegistroServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador REST para gestionar consultas de libros en una base de datos PostgreSQL
 * basadas en su fecha de registro.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/prd-rex/libros/consulta/postgresSQL")
public class LibroFechaRegistroPostgresRestController {

    /** Servicio para realizar operaciones relacionadas con libros en PostgreSQL. */
    private final LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres;

    /**
     * Constructor de la clase.
     *
     * @param libroFechaRegistroServicePostgres el servicio que maneja las consultas de libros en PostgreSQL.
     */
    public LibroFechaRegistroPostgresRestController(LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres) {
        this.libroFechaRegistroServicePostgres = libroFechaRegistroServicePostgres;
    }

    /**
     * Consulta libros registrados en PostgreSQL dentro de un rango de fechas.
     *
     * @param fechaInicio la fecha de inicio del rango de consulta (inclusive).
     * @param fechaFin    la fecha de fin del rango de consulta (inclusive).
     * @return una respuesta HTTP que contiene una lista de libros registrados en el rango de fechas especificado.
     *         Devuelve un código de estado HTTP adecuado dependiendo del resultado.
     */
    @GetMapping("/fecharegistro")
    public ResponseEntity<List<LibroDTO>> getLibrosByFechaRegistroPostgres(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        return libroFechaRegistroServicePostgres.getLibrosByFechaRegistroPostgres(fechaInicio, fechaFin);
    }
}
