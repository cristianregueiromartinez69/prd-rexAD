package com.cristianProyectoAD.prd_rex.consultas.fecharegistro.postgres.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio para gestionar consultas de libros registrados en una base de datos PostgreSQL
 * basadas en su fecha de registro.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroFechaRegistroServicePostgres {

    /** Cliente para comunicarse con la base de datos PostgreSQL. */
    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    /**
     * Constructor de la clase.
     *
     * @param postgresSQLPrdClientService el cliente que maneja la comunicación con PostgreSQL.
     */
    public LibroFechaRegistroServicePostgres(PostgresSQLPrdClientService postgresSQLPrdClientService) {
        this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    /**
     * Obtiene una lista de libros registrados en PostgreSQL dentro de un rango de fechas.
     *
     * @param fechaInicio la fecha de inicio del rango de consulta (inclusive).
     * @param fechaFin    la fecha de fin del rango de consulta (inclusive).
     * @return una respuesta HTTP que contiene una lista de objetos {@link LibroDTO} correspondientes
     *         a los libros registrados dentro del rango especificado.
     */
    public ResponseEntity<List<LibroDTO>> getLibrosByFechaRegistroPostgres(LocalDate fechaInicio, LocalDate fechaFin) {
        return postgresSQLPrdClientService.getLibroByFechaRegistro(fechaInicio, fechaFin);
    }
}
