package com.cristianProyectoAD.prd_rex.consultas.fechalectura.postgres.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibroFechaLecturaServicePostgres {

    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    public LibroFechaLecturaServicePostgres(PostgresSQLPrdClientService postgresSQLPrdClientService) {
        this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    public ResponseEntity<List<LibroDTO>> getLibrosPostgresFechaLectura(LocalDate fechaInicio, LocalDate fechaFin) {
        return postgresSQLPrdClientService.getLibroByFechaLectura(fechaInicio, fechaFin);
    }
}
