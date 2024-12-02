package com.cristianProyectoAD.prd_rex.consultas.nombre.mongo.controlador;

import com.cristianProyectoAD.prd_rex.consultas.nombre.mongo.servicio.LibroNombreServiceMongo;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controlador REST para gestionar consultas de libros en una base de datos MongoDB
 * basadas en su nombre.
 */
@RestController
@RequestMapping("/prd-rex/libros/consulta/mongoDB/")
public class LibroNombreMongoRestController {

    /** Servicio encargado de realizar consultas en MongoDB relacionadas con los nombres de libros. */
    private final LibroNombreServiceMongo libroNombreServiceMongo;

    /**
     * Constructor de la clase.
     *
     * @param libroNombreServiceMongo el servicio que maneja las consultas de nombres de libros en MongoDB.
     */
    public LibroNombreMongoRestController(LibroNombreServiceMongo libroNombreServiceMongo) {
        this.libroNombreServiceMongo = libroNombreServiceMongo;
    }

    /**
     * Obtiene una lista de libros de MongoDB cuyo nombre coincide con el nombre proporcionado.
     *
     * @param nombre el nombre del libro a buscar.
     * @return una respuesta HTTP que contiene una lista de objetos {@link LibroDTO} correspondientes
     *         a los libros encontrados.
     */
    @GetMapping("nombre{nombre}")
    public ResponseEntity<List<LibroDTO>> getLibroByNombre(@PathVariable String nombre) {
        return libroNombreServiceMongo.getLibroNombreMongo(nombre);
    }
}
