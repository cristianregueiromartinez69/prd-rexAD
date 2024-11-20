package com.cristianProyectoAD.prd_rex.consultas.autor.postgres.controlador;

import com.cristianProyectoAD.prd_rex.consultas.autor.postgres.servicio.LibroAutorServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para consultas de libros en PostgreSQL por autor.
 * Proporciona un endpoint para recuperar una lista de libros basados en el autor.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/prd-rex/libros/consulta/postgresSQL/")
public class LibroAutorPostgresRestController {

    private final LibroAutorServicePostgres libroAutorServicePostgres;

    /**
     * Constructor del controlador.
     *
     * @param libroAutorServicePostgres Servicio que maneja las consultas de libros por autor en PostgreSQL.
     */
    public LibroAutorPostgresRestController(LibroAutorServicePostgres libroAutorServicePostgres) {
        this.libroAutorServicePostgres = libroAutorServicePostgres;
    }

    /**
     * Endpoint para obtener una lista de libros en PostgreSQL basados en el autor.
     *
     * @param autor El nombre del autor.
     * @return ResponseEntity con la lista de libros del autor si se encuentran.
     */
    @GetMapping("autor{autor}")
    public ResponseEntity<List<LibroDTO>> getLibroPostgresByAutor(@PathVariable String autor) {
        return libroAutorServicePostgres.getLibroByAutor(autor);
    }
}
