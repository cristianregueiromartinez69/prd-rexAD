package com.cristianProyectoAD.prd_rex.servicio_comunicacion;

import com.cristianProyectoAD.prd_rex.dto.LibroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "relational-prd-query", url = "http://localhost:8082")
public interface PostgresSQLPrdClientService {

    @PostMapping("/libros/guardar")
    ResponseEntity<String> saveBooksPostgres(@RequestBody LibroDTO libroDTO);
}
