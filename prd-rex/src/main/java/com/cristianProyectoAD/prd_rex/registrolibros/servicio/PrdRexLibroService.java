package com.cristianProyectoAD.prd_rex.registrolibros.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.registrolibros.servicio_comunicacion.MongoPrdClientService;
import com.cristianProyectoAD.prd_rex.registrolibros.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PrdRexLibroService {

    private final MongoPrdClientService mongoPrdClientService;
    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    public PrdRexLibroService(MongoPrdClientService mongoPrdClientService, PostgresSQLPrdClientService postgresSQLPrdClientService) {
        this.mongoPrdClientService = mongoPrdClientService;
        this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    public ResponseEntity<String> registroLibrosBases(@RequestBody LibroDTO libroDTO){

        ResponseEntity<String> responsePostgres = postgresSQLPrdClientService.saveBooksPostgres(libroDTO);
        ResponseEntity<String> responseMongo = mongoPrdClientService.saveBooksMongo(libroDTO);

        if(responsePostgres.getStatusCode().is2xxSuccessful() && responseMongo.getStatusCode().is2xxSuccessful()){
            return ResponseEntity.ok("Libro registrado correctamente en las bases de datos");
        }
        else {
            return ResponseEntity.status(500).body("Error al registrar el libro en las bases de datos");
        }

    }
}
