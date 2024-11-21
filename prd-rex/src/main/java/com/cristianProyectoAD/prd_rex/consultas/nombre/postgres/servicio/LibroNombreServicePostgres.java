package com.cristianProyectoAD.prd_rex.consultas.nombre.postgres.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroNombreServicePostgres {

    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    public LibroNombreServicePostgres(PostgresSQLPrdClientService postgresSQLPrdClientService) {
       this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    public ResponseEntity<List<LibroDTO>> getLibrosPostgresByNombre(String nombre) {
        return postgresSQLPrdClientService.getLibroByNombre(nombre);
    }




}
