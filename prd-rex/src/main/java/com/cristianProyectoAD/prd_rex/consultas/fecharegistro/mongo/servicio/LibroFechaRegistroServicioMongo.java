package com.cristianProyectoAD.prd_rex.consultas.fecharegistro.mongo.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.MongoPrdClientService;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibroFechaRegistroServicioMongo {

    private final MongoPrdClientService mongoPrdClientService;

    public LibroFechaRegistroServicioMongo(MongoPrdClientService mongoPrdClientService) {
        this.mongoPrdClientService = mongoPrdClientService;
    }

    public ResponseEntity<List<LibroDTO>> getLibrosByFechaRMongo(LocalDate fechaInicio, LocalDate fechaFin) {
        return mongoPrdClientService.getLibroByFechaRegistro(fechaInicio, fechaFin);
    }
}
