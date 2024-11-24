package com.cristianProyectoAD.prd_rex.consultas.isbn.mongodb.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.MongoPrdClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Servicio encargado de gestionar la consulta de libros en MongoDB por ISBN.
 * Se comunica con el cliente de MongoDB para obtener los datos del libro basado en el ISBN.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroIsbnServiceMongoDB {

    private final MongoPrdClientService mongoPrdClientService;

    /**
     * Constructor del servicio.
     *
     * @param mongoPrdClientService Cliente que maneja la comunicación con la base de datos MongoDB.
     */
    public LibroIsbnServiceMongoDB(MongoPrdClientService mongoPrdClientService) {
        this.mongoPrdClientService = mongoPrdClientService;
    }

    /**
     * Consulta un libro en MongoDB utilizando su ISBN.
     *
     * @param isbn El ISBN del libro.
     * @return ResponseEntity con los datos del libro si se encuentra.
     */
    public ResponseEntity<LibroDTO> getLibroByIsbnMongo(@RequestParam String isbn) {
        return mongoPrdClientService.getLibroByIsbn(isbn);
    }
}
