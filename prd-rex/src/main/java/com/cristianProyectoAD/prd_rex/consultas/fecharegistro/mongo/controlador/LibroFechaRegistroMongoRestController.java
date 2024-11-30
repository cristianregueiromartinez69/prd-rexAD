package com.cristianProyectoAD.prd_rex.consultas.fecharegistro.mongo.controlador;

import com.cristianProyectoAD.prd_rex.consultas.fecharegistro.mongo.servicio.LibroFechaRegistroServicioMongo;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prd-rex/libros/consulta/mongoDB")
public class LibroFechaRegistroMongoRestController {

    private final LibroFechaRegistroServicioMongo libroFechaRegistroServicio;

    public LibroFechaRegistroMongoRestController(LibroFechaRegistroServicioMongo libroFechaRegistroServicio) {
        this.libroFechaRegistroServicio = libroFechaRegistroServicio;
    }

    @GetMapping("/fecharegistro")
    public ResponseEntity<List<LibroDTO>> getLibrosMongoFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) {
        return libroFechaRegistroServicio.getLibrosByFechaRMongo(fechaInicio, fechaFin);
    }

}
