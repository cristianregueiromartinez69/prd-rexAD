package com.cristianProyectoAD.prd_rex.consultas.fechalectura.mongo.service;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.MongoPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Haciendo servicio de consulta de libro entre fechas de lectura
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroFechaLecturaServicioMongo {

    //servicio de comunicacion con mongo
    private final MongoPrdClientService mongoPrdClientService;

    /**
     * Constructor de la clase
     * @param mongoPrdClientService el servicio de comunicacion con mongo
     */
    public LibroFechaLecturaServicioMongo(MongoPrdClientService mongoPrdClientService) {
        this.mongoPrdClientService = mongoPrdClientService;
    }

    /**
     * Metodo que me devuelve una lista de libros por fecha de lectura
     * @param fechaInicio la fecha de inicio
     * @param fechaFin la fecha de fin
     * @return la lista de libros entre fechas de lectura
     */
    public ResponseEntity<List<LibroDTO>> consultaLibroFechaLecturaService(LocalDate fechaInicio, LocalDate fechaFin) {
        return mongoPrdClientService.getLirboByFechaLectura(fechaInicio, fechaFin);
    }
}
