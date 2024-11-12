package com.cristianProyectoAD.prd_rex.consultas.isbn.postgresSQL.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.registrolibros.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LibroIsbnService {

    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    public LibroIsbnService(PostgresSQLPrdClientService postgresSQLPrdClientService) {
        this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    public ResponseEntity<LibroDTO> getLibroByIsbn(@RequestParam String isbn) {
        ResponseEntity<LibroDTO> responsePostgres = postgresSQLPrdClientService.getLibroByIsbn(isbn);

        if(responsePostgres.getStatusCode() == HttpStatus.NOT_FOUND) {
            return new ResponseEntity<>(responsePostgres.getBody(), HttpStatus.NOT_FOUND);
        }
        return responsePostgres;
    }
}
