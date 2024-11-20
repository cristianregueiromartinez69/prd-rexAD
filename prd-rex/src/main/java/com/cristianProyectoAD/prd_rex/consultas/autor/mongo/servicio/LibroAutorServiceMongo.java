package com.cristianProyectoAD.prd_rex.consultas.autor.mongo.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.MongoPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroAutorServiceMongo {

    private final MongoPrdClientService mongoPrdClientService;

    /**
     * Constructor del servicio.
     *
     * @param mongoPrdClientService Cliente que maneja la comunicación con la base de datos mongoDB.
     */
    public LibroAutorServiceMongo(MongoPrdClientService mongoPrdClientService) {
        this.mongoPrdClientService = mongoPrdClientService;
    }

    /**
     * Consulta libros en mongoDB utilizando el nombre de un autor.
     *
     * @param autor El nombre del autor.
     * @return ResponseEntity con la lista de libros del autor si se encuentran.
     */
    public ResponseEntity<List<LibroDTO>> getLibroByAutor(String autor) {
        return mongoPrdClientService.getLibroByAutor(autor);
    }
}
