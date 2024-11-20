package com.cristianProyectoAD.prd_rex.consultas.autor.postgres.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroAutorServicePostgres {

    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    public LibroAutorServicePostgres(PostgresSQLPrdClientService postgresSQLPrdClientService) {
        this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    public ResponseEntity<List<LibroDTO>> getLibroByAutor(String autor) {
        return postgresSQLPrdClientService.getLibroByAutor(autor);
    }
}
