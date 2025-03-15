package com.cristianProyectoAD.prd_rex.consultas.isbn.mongodb.controlador;

import com.cristianProyectoAD.prd_rex.consultas.isbn.mongodb.servicio.LibroIsbnServiceMongoDB;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para consultar libros en MongoDB por ISBN.
 * Proporciona un endpoint para recuperar un libro basado en su ISBN desde la base de datos MongoDB.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/prd-rex/libros/consulta/mongoDB")
public class LibroConsultaIsbnMongoRestController {

    private final LibroIsbnServiceMongoDB libroIsbnService;

    /**
     * Constructor del controlador.
     *
     * @param libroIsbnService Servicio que maneja las consultas de libros por ISBN en MongoDB.
     */
    public LibroConsultaIsbnMongoRestController(LibroIsbnServiceMongoDB libroIsbnService) {
        this.libroIsbnService = libroIsbnService;
    }

    /**
     * Endpoint para obtener un libro en MongoDB utilizando su ISBN.
     *
     * @param isbn El ISBN del libro.
     * @return ResponseEntity con los datos del libro si se encuentra.
     */
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<LibroDTO> getLibroByIsbn(@PathVariable("isbn") String isbn) {
        return libroIsbnService.getLibroByIsbnMongo(isbn);
    }
}
