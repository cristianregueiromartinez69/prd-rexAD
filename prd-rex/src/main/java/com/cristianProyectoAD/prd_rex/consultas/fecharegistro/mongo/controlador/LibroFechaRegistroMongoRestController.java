package com.cristianProyectoAD.prd_rex.consultas.fecharegistro.mongo.controlador;

import com.cristianProyectoAD.prd_rex.consultas.fecharegistro.mongo.servicio.LibroFechaRegistroServicioMongo;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador REST para manejar consultas relacionadas con libros
 * almacenados en una base de datos MongoDB según su fecha de registro.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/prd-rex/libros/consulta/mongoDB")
public class LibroFechaRegistroMongoRestController {

    /** Servicio para realizar operaciones de consulta en MongoDB. */
    private final LibroFechaRegistroServicioMongo libroFechaRegistroServicio;

    /**
     * Constructor de la clase.
     *
     * @param libroFechaRegistroServicio el servicio que proporciona las operaciones de consulta en MongoDB.
     */
    public LibroFechaRegistroMongoRestController(LibroFechaRegistroServicioMongo libroFechaRegistroServicio) {
        this.libroFechaRegistroServicio = libroFechaRegistroServicio;
    }

    /**
     * Endpoint para obtener una lista de libros registrados en una base de datos MongoDB
     * dentro de un rango de fechas especificado.
     *
     * @param fechaInicio la fecha de inicio del rango de consulta (inclusive).
     * @param fechaFin    la fecha de fin del rango de consulta (inclusive).
     * @return una respuesta HTTP con la lista de libros encontrados dentro del rango de fechas.
     *         Devuelve un código de estado HTTP adecuado en función del resultado.
     */
    @GetMapping("/fecharegistro")
    public ResponseEntity<List<LibroDTO>> getLibrosMongoFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) {
        return libroFechaRegistroServicio.getLibrosByFechaRMongo(fechaInicio, fechaFin);
    }

}
