package com.cristianProyectoAD.prd_rex.consultas.isbn.postgresSQL.controlador;

import com.cristianProyectoAD.prd_rex.consultas.isbn.postgresSQL.servicio.LibroIsbnService;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prd-rex/libros/consulta/postresSQL")
public class LibroConsultaIsbnRestController {

    private final LibroIsbnService libroIsbnService;

    public LibroConsultaIsbnRestController(LibroIsbnService libroIsbnService) {
        this.libroIsbnService = libroIsbnService;
    }

    @GetMapping("isbn/{isbn}")
    public ResponseEntity<LibroDTO> getLibroByIsbn(@PathVariable("isbn") String isbn) {
        return libroIsbnService.getLibroByIsbn(isbn);
    }
}
