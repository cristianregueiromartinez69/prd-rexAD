package com.cristianProyectoAD.prd_rex.consultas.fecharegistro.postgres.controlador;

import com.cristianProyectoAD.prd_rex.consultas.fecharegistro.postgres.servicio.LibroFechaRegistroServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prd-rex/libros/consulta/postgresSQL/fecharegistro")
public class LibroFechaRegistroPostgresRestController {

    private final LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres;

    public LibroFechaRegistroPostgresRestController(LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres) {
        this.libroFechaRegistroServicePostgres = libroFechaRegistroServicePostgres;
    }

    @GetMapping("/{fechaInicio}/{fechaFin}")
    public ResponseEntity<List<LibroDTO>> getLibrosByFechaRegistroPostgres(@PathVariable("fechaInicio") LocalDate fechaInicio, @PathVariable("fechaFin") LocalDate fechaFin) {
        return libroFechaRegistroServicePostgres.getLibrosByFechaRegistroPostgres(fechaInicio, fechaFin);
    }
}
