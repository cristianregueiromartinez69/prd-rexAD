package com.cristianProyectoAD.prd_rex.consultas.nombre.mongo.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.MongoPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroNombreServiceMongo {

    private final MongoPrdClientService mongoPrdClientService;

    public LibroNombreServiceMongo(MongoPrdClientService mongoPrdClientService) {
        this.mongoPrdClientService = mongoPrdClientService;
    }

    public ResponseEntity<List<LibroDTO>> getLibroNombreMongo(String nombre) {
        return mongoPrdClientService.getLibroByNombre(nombre);
    }
}
