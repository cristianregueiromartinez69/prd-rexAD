package com.cristianProyectoAD.prd_rex.consultas.nombre.mongo.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.MongoPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar consultas relacionadas con los nombres de libros en una base de datos MongoDB.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroNombreServiceMongo {

    /** Cliente para comunicarse con MongoDB y realizar operaciones relacionadas con libros. */
    private final MongoPrdClientService mongoPrdClientService;

    /**
     * Constructor de la clase.
     *
     * @param mongoPrdClientService el cliente utilizado para interactuar con MongoDB.
     */
    public LibroNombreServiceMongo(MongoPrdClientService mongoPrdClientService) {
        this.mongoPrdClientService = mongoPrdClientService;
    }

    /**
     * Obtiene una lista de libros cuyo nombre coincide con el proporcionado desde la base de datos MongoDB.
     *
     * @param nombre el nombre del libro a buscar.
     * @return una respuesta HTTP que contiene una lista de objetos {@link LibroDTO} correspondientes
     *         a los libros encontrados.
     */
    public ResponseEntity<List<LibroDTO>> getLibroNombreMongo(String nombre) {
        return mongoPrdClientService.getLibroByNombre(nombre);
    }
}
