package com.cristianProyectoAD.prd_rex.registrolibros.servicio_comunicacion;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Servicio de comunicacion con el microservicio de mongo para mandar registro de libros
 * @author cristian
 * @version 1.0
 */
@FeignClient(name = "nonrelational-prd-query", url="http://localhost:8083")
public interface MongoPrdClientService {

    /**
     * Metodo para mandar el libro a la base de datos de mongo
     * @param libroDTO el libro
     * @return un mensage indicando si se envió correctamente o no
     */
    @PostMapping("/nonrelational-prd-query/libros/guardar")
    ResponseEntity<String> saveBooksMongo(@RequestBody LibroDTO libroDTO);
}
