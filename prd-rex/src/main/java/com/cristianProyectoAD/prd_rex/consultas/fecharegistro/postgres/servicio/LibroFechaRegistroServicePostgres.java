package com.cristianProyectoAD.prd_rex.consultas.fecharegistro.postgres.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibroFechaRegistroServicePostgres {

    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    public LibroFechaRegistroServicePostgres(PostgresSQLPrdClientService postgresSQLPrdClientService) {
        this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    public ResponseEntity<List<LibroDTO>> getLibrosByFechaRegistroPostgres(LocalDate fechaInicio, LocalDate fechaFin) {
        return postgresSQLPrdClientService.getLibroByFechaRegistro(fechaInicio, fechaFin);
    }
}
