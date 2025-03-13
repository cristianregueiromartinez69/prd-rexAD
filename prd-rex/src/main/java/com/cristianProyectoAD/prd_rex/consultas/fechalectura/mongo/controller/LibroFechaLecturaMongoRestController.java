package com.cristianProyectoAD.prd_rex.consultas.fechalectura.mongo.controller;

import com.cristianProyectoAD.prd_rex.consultas.fechalectura.mongo.service.LibroFechaLecturaServicioMongo;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * RestController para de libros por fecha de lectura
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/prd-rex/libros/consulta/mongoDB")
public class LibroFechaLecturaMongoRestController {

    //variable del servicio de la aplicacion
    private final LibroFechaLecturaServicioMongo libroFechaLecturaServicioMongo;

    /**
     * Constructor de la clase
     * @param libroFechaLecturaServicioMongo servicio de mongo
     */
    public LibroFechaLecturaMongoRestController(LibroFechaLecturaServicioMongo libroFechaLecturaServicioMongo) {
        this.libroFechaLecturaServicioMongo = libroFechaLecturaServicioMongo;
    }

    /**
     * Metodo get para obtener un listado de libros entre fechas de lectura
     * @param fechaInicio la fecha de inicio
     * @param fechaFin la fecha de fin
     * @return el listado de libros entre fechas
     */
    @GetMapping("/fechalectura")
    public ResponseEntity<List<LibroDTO>> getLibrosMongoByFechaLecturaRestController(@RequestParam("fechaInicio") LocalDate fechaInicio,
                                                                                     @RequestParam("fechaFin") LocalDate fechaFin){

        return libroFechaLecturaServicioMongo.consultaLibroFechaLecturaService(fechaInicio, fechaFin);
    }


}
