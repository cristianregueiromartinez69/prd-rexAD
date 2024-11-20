package com.cristianProyectoAD.prd_rex.consultas.isbn.mongodb.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.MongoPrdClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LibroIsbnServiceMongoDB {

    private final MongoPrdClientService mongoPrdClientService;

    public LibroIsbnServiceMongoDB(MongoPrdClientService mongoPrdClientService) {
        this.mongoPrdClientService = mongoPrdClientService;
    }

    public ResponseEntity<LibroDTO> getLibroByIsbnMongo(@RequestParam String isbn) {
        ResponseEntity<LibroDTO> responsePostgres = mongoPrdClientService.getLibroByIsbn(isbn);

        if(responsePostgres.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return responsePostgres;
    }
}
