package com.cristianProyectoAD.prd_rex.registrolibros.servicio;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.MongoPrdClientService;
import com.cristianProyectoAD.prd_rex.servicio_comunicacion.PostgresSQLPrdClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Clase servicio del microservicio para el registro de libros
 * @author cristian
 * 2version 1.0
 */
@Service
public class PrdRexLibroService {

    /**
     * Variables privadas para mandar los resultados a las bases de datos
     */
    private final MongoPrdClientService mongoPrdClientService;
    private final PostgresSQLPrdClientService postgresSQLPrdClientService;

    /**
     * Constructor de la clase
     * @param mongoPrdClientService el servicio cliente a donde mandar mongo
     * @param postgresSQLPrdClientService el servicio cliente a donde mandar postgres
     */
    public PrdRexLibroService(MongoPrdClientService mongoPrdClientService, PostgresSQLPrdClientService postgresSQLPrdClientService) {
        this.mongoPrdClientService = mongoPrdClientService;
        this.postgresSQLPrdClientService = postgresSQLPrdClientService;
    }

    /**
     * Metodo para registrar los libros en las bases de datos de los clientes de mongo y postgresSQL
     * @param libroDTO el libro a registrar
     * @return el registro del libro
     */
    public ResponseEntity<String> registroLibrosBases(@RequestBody LibroDTO libroDTO){

        /**
         * Hacemos 2 responseEntitys iguales a los metodos que mandan os libros a las bases de datos
         */
        ResponseEntity<String> responsePostgres = postgresSQLPrdClientService.saveBooksPostgres(libroDTO);
        ResponseEntity<String> responseMongo = mongoPrdClientService.saveBooksMongo(libroDTO);

        /**
         * Si las bases de datos tuvieron éxito en el registro, manda un mensaje de todo ok
         * si no manda un error
         */
        if(responsePostgres.getStatusCode().is2xxSuccessful() && responseMongo.getStatusCode().is2xxSuccessful()){
            return ResponseEntity.ok("Libro registrado correctamente en las bases de datos");
        }
        else {
            return ResponseEntity.status(500).body("Error al registrar el libro en las bases de datos");
        }

    }
}
