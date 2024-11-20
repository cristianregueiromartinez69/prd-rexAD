package com.cristianProyectoAD.prd_rex.consultas.autor.mongo.controlador;

import com.cristianProyectoAD.prd_rex.consultas.autor.mongo.servicio.LibroAutorServiceMongo;
import com.cristianProyectoAD.prd_rex.consultas.autor.postgres.servicio.LibroAutorServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prd-rex/libros/consulta/mongoDB/")
public class LibroAutorMongoRestController {

    private final LibroAutorServiceMongo libroAutorServiceMongo;

    /**
     * Constructor del controlador.
     *
     * @param libroAutorServiceMongo Servicio que maneja las consultas de libros por autor en MongoDB.
     */
    public LibroAutorMongoRestController(LibroAutorServiceMongo libroAutorServiceMongo) {
        this.libroAutorServiceMongo = libroAutorServiceMongo;
    }

    /**
     * Endpoint para obtener una lista de libros en MongoDB basados en el autor.
     *
     * @param autor El nombre del autor.
     * @return ResponseEntity con la lista de libros del autor si se encuentran.
     */
    @GetMapping("autor{autor}")
    public ResponseEntity<List<LibroDTO>> getLibrosMongoByAutor(@PathVariable String autor) {
        return libroAutorServiceMongo.getLibroByAutor(autor);
    }
}
