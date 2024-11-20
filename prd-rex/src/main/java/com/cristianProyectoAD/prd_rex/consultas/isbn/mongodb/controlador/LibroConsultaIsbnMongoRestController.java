package com.cristianProyectoAD.prd_rex.consultas.isbn.mongodb.controlador;

import com.cristianProyectoAD.prd_rex.consultas.isbn.mongodb.servicio.LibroIsbnServiceMongoDB;
import com.cristianProyectoAD.prd_rex.consultas.isbn.postgresSQL.servicio.LibroIsbnServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prd-rex/libros/consulta/mongoDB/")
public class LibroConsultaIsbnMongoRestController {

    private final LibroIsbnServiceMongoDB libroIsbnService;

    public LibroConsultaIsbnMongoRestController(LibroIsbnServiceMongoDB libroIsbnService) {
        this.libroIsbnService = libroIsbnService;
    }

    @GetMapping("isbn/{isbn}")
    public ResponseEntity<LibroDTO> getLibroByIsbn(@PathVariable("isbn") String isbn) {
        return libroIsbnService.getLibroByIsbnMongo(isbn);
    }
}
