package com.cristianProyectoAD.prd_rex.registrolibros.controlador;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.registrolibros.servicio.PrdRexLibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prd-rex/libros")
public class RestControllerRegistroLibros {

    private final PrdRexLibroService prdRexLibroService;

    public RestControllerRegistroLibros(PrdRexLibroService prdRexLibroService) {
        this.prdRexLibroService = prdRexLibroService;
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registroLibrosBasesDatos(@RequestBody LibroDTO libroDTO) {
        return prdRexLibroService.registroLibrosBases(libroDTO);
    }
}
