package com.cristianProyectoAD.prd_rex.consultas.nombre.mongo.controlador;

import com.cristianProyectoAD.prd_rex.consultas.nombre.mongo.servicio.LibroNombreServiceMongo;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prd-rex/libros/consulta/mongoDB/")
public class LibroNombreMongoRestController {

    private final LibroNombreServiceMongo libroNombreServiceMongo;

    public LibroNombreMongoRestController(LibroNombreServiceMongo libroNombreServiceMongo) {
        this.libroNombreServiceMongo = libroNombreServiceMongo;
    }

    @GetMapping("nombre{nombre}")
    public ResponseEntity<List<LibroDTO>> getLibroByNombre(@PathVariable String nombre) {
        return libroNombreServiceMongo.getLibroNombreMongo(nombre);
    }
}
