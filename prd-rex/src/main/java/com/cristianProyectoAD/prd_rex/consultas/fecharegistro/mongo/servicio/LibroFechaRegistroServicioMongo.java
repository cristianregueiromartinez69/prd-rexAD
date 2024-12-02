package com.cristianProyectoAD.prd_rex.consultas.fecharegistro.mongo.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.MongoPrdClientService;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio que proporciona operaciones para consultar libros en una base de datos MongoDB
 * según su fecha de registro.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroFechaRegistroServicioMongo {

    /** Servicio cliente para interactuar con la base de datos MongoDB. */
    private final MongoPrdClientService mongoPrdClientService;

    /**
     * Constructor de la clase.
     *
     * @param mongoPrdClientService el servicio cliente que maneja las operaciones en MongoDB.
     */
    public LibroFechaRegistroServicioMongo(MongoPrdClientService mongoPrdClientService) {
        this.mongoPrdClientService = mongoPrdClientService;
    }

    /**
     * Obtiene una lista de libros registrados en MongoDB dentro de un rango de fechas especificado.
     *
     * @param fechaInicio la fecha de inicio del rango de consulta (inclusive).
     * @param fechaFin    la fecha de fin del rango de consulta (inclusive).
     * @return una respuesta HTTP que contiene una lista de libros registrados en el rango de fechas proporcionado.
     *         Devuelve un código de estado HTTP adecuado según el resultado.
     */
    public ResponseEntity<List<LibroDTO>> getLibrosByFechaRMongo(LocalDate fechaInicio, LocalDate fechaFin) {
        return mongoPrdClientService.getLibroByFechaRegistro(fechaInicio, fechaFin);
    }
}
