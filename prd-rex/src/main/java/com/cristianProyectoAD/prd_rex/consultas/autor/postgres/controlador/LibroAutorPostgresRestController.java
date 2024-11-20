package com.cristianProyectoAD.prd_rex.consultas.autor.postgres.controlador;

import com.cristianProyectoAD.prd_rex.consultas.autor.postgres.servicio.LibroAutorServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prd-rex/libros/consulta/postgresSQL/")
public class LibroAutorPostgresRestController {

    private final LibroAutorServicePostgres libroAutorServicePostgres;

    public LibroAutorPostgresRestController(LibroAutorServicePostgres libroAutorServicePostgres) {
        this.libroAutorServicePostgres = libroAutorServicePostgres;
    }

    @GetMapping("autor{autor}")
    public ResponseEntity<List<LibroDTO>> getLibroPostgresByAutor(@PathVariable String autor) {
        return libroAutorServicePostgres.getLibroByAutor(autor);
    }
}
