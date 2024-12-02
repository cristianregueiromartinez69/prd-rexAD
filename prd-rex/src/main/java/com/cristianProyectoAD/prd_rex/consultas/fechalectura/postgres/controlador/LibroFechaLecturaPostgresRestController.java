package com.cristianProyectoAD.prd_rex.consultas.fechalectura.postgres.controlador;

import com.cristianProyectoAD.prd_rex.consultas.fechalectura.postgres.servicio.LibroFechaLecturaServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prd-rex/libros/consulta/postgresSQL")
public class LibroFechaLecturaPostgresRestController {

    private final LibroFechaLecturaServicePostgres libroFechaLecturaServicePostgres;

    public LibroFechaLecturaPostgresRestController(LibroFechaLecturaServicePostgres libroFechaLecturaServicePostgres) {
        this.libroFechaLecturaServicePostgres = libroFechaLecturaServicePostgres;
    }

    @GetMapping("/fechalectura")
    public ResponseEntity<List<LibroDTO>> getLibrosFechaLecturaPostgres(LocalDate fechaInicio, LocalDate fechaFin) {
        return libroFechaLecturaServicePostgres.getLibrosPostgresFechaLectura(fechaInicio, fechaFin);
    }

}
