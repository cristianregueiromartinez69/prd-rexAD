package com.cristianProyectoAD.prd_rex.consultas.nombre.postgres.controlador;

import com.cristianProyectoAD.prd_rex.consultas.nombre.postgres.servicio.LibroNombreServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prd-rex/libros/consulta/postgresSQL/")
public class LibroNombrePostgresRestController {

    private final LibroNombreServicePostgres libroNombreServicePostgres;

    public LibroNombrePostgresRestController(LibroNombreServicePostgres libroNombreServicePostgres) {
        this.libroNombreServicePostgres = libroNombreServicePostgres;
    }

    @GetMapping("nombre{nombre}")
    public ResponseEntity<List<LibroDTO>> getLibroByNombre(@PathVariable String nombre) {
        return libroNombreServicePostgres.getLibrosPostgresByNombre(nombre);
    }
}
