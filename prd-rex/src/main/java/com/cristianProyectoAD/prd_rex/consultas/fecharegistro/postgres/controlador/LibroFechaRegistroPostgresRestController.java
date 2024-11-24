package com.cristianProyectoAD.prd_rex.consultas.fecharegistro.postgres.controlador;

import com.cristianProyectoAD.prd_rex.consultas.fecharegistro.postgres.servicio.LibroFechaRegistroServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prd-rex/libros/consulta/postgresSQL")
public class LibroFechaRegistroPostgresRestController {

    private final LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres;

    public LibroFechaRegistroPostgresRestController(LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres) {
        this.libroFechaRegistroServicePostgres = libroFechaRegistroServicePostgres;
    }

    @GetMapping("/fecharegistro")
    public ResponseEntity<List<LibroDTO>> getLibrosByFechaRegistroPostgres(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        return libroFechaRegistroServicePostgres.getLibrosByFechaRegistroPostgres(fechaInicio, fechaFin);
    }
}
