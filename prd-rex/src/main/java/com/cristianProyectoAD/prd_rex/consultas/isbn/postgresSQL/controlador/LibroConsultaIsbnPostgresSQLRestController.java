package com.cristianProyectoAD.prd_rex.consultas.isbn.postgresSQL.controlador;

import com.cristianProyectoAD.prd_rex.consultas.isbn.postgresSQL.servicio.LibroIsbnServicePostgres;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prd-rex/libros/consulta/postresSQL/")
public class LibroConsultaIsbnPostgresSQLRestController {

    private final LibroIsbnServicePostgres libroIsbnService;

    public LibroConsultaIsbnPostgresSQLRestController(LibroIsbnServicePostgres libroIsbnService) {
        this.libroIsbnService = libroIsbnService;
    }

    @GetMapping("isbn/{isbn}")
    public ResponseEntity<LibroDTO> getLibroByIsbn(@PathVariable("isbn") String isbn) {
        return libroIsbnService.getLibroByIsbnPostgres(isbn);
    }
}
